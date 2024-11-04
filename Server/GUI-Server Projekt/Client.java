import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 4711;

    private JTextPane chatArea;
    private JTextField messageField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton sendButton;
    private JButton loginButton;
    private JButton logoutButton;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private JPanel loginPanel;

    public Client() {
        setupUI(); // Setup the user interface
        setVisible(true);
    }

    private void setupUI() {
        // Setup the main UI components
        setTitle("Chat Client");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupChatArea(); // Setup the chat area
        setupMessagePanel(); // Setup the message panel
        setupLoginPanel(); // Setup the login panel
    }

    private void setupChatArea() {
        // Setup the chat area
        chatArea = new JTextPane();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
    }

    private void setupMessagePanel() {
        // Setup the message panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        messageField = new JTextField();
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(); // Send message on Enter key press
                }
            }
        });

        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage()); // Send message on button click

        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);
    }

    private void setupLoginPanel() {
        // Setup the login panel
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            connectToServer(); // Connect to the server
            login(); // Login to the server
        });

        loginPanel.add(new JLabel("Username:", SwingConstants.RIGHT));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.NORTH);
    }

    private void connectToServer() {
        // Connect to the server
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new IncomingReader()).start(); // Start a thread to read incoming messages
        } catch (IOException e) {
            showErrorDialog("Verbindung zum Server fehlgeschlagen.");
        }
    }

    private void showErrorDialog(String message) {
        // Show an error dialog
        JOptionPane.showMessageDialog(this, message, "Connection Error", JOptionPane.ERROR_MESSAGE);
    }

    private void login() {
        // Send login credentials to the server
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        out.println("LOGIN " + username + " " + password);
        passwordField.setText("");
    }

    private void addLogoutButton() {
        // Add a logout button to the UI
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> logout());

        loginPanel.setLayout(new BorderLayout());
        loginPanel.removeAll();
        loginPanel.add(logoutButton, BorderLayout.CENTER);
        loginPanel.revalidate();
        loginPanel.repaint();
    }

    private void logout() {
        // Logout from the server
        try {
            out.println("LOGOUT");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        resetUIForLogin(); // Reset the UI for login
    }

    private void resetUIForLogin() {
        // Reset the UI for login
        loginPanel.removeAll();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));
        loginPanel.add(new JLabel("Username:", SwingConstants.RIGHT));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        loginPanel.revalidate();
        loginPanel.repaint();
        chatArea.setText("");
    }

    private void sendMessage() {
        // Send a message to the server
        String message = messageField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            messageField.setText("");
        }
    }

    public void clearChat() {
        // Clear the chat area
        try {
            Document doc = chatArea.getDocument();
            doc.remove(0, doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void appendToChat(String message, boolean isServerMessage, boolean isSuccess) {
        // Append a message to the chat area
        StyledDocument doc = chatArea.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();

        if (isServerMessage) {
            StyleConstants.setFontFamily(style, "SansSerif");
            StyleConstants.setBold(style, true);
            StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);

            if (isSuccess) {
                StyleConstants.setForeground(style, Color.BLACK);
            } else {
                StyleConstants.setForeground(style, Color.RED);
            }
        } else {
            StyleConstants.setFontFamily(style, "Arial");
            StyleConstants.setForeground(style, Color.BLACK);
            StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
        }

        try {
            int length = doc.getLength();
            doc.insertString(length, message + "\n", style);
            doc.setParagraphAttributes(length, message.length(), style, false);
            chatArea.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            // Read incoming messages from the server
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    handleIncomingMessage(message); // Handle incoming messages
                }
            } catch (IOException e) {
                SwingUtilities.invokeLater(Client.this::logout);
            }
        }

        private void handleIncomingMessage(String message) {
            // Handle incoming messages
            if (message.startsWith("LOGIN SUCCESS")) {
                clearChat();
                appendToChat(message, true, true);
                SwingUtilities.invokeLater(Client.this::addLogoutButton);
            } else if (message.startsWith("LOGIN FAILED")) {
                appendToChat(message, true, false);
            } else if (message.startsWith("LOGOUT")) {
                appendToChat(message, true, false);
                scheduleLogout();
            } else if (message.contains("betreten")) {
                appendToChat(message, true, true);
            } else if (message.contains("verlassen")) {
                appendToChat(message, true, false);
            } else {
                appendToChat(message, false, false);
            }
        }

        private void scheduleLogout() {
            // Schedule a logout after 2 seconds
            Timer timer = new Timer(2000, e -> SwingUtilities.invokeLater(Client.this::logout));
            timer.setRepeats(false);
            timer.start();
        }
    }

    public static void main(String[] args) {
        new Client(); // Start the client
    }
}

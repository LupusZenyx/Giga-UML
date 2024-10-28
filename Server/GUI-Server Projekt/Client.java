import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        setTitle("Chat Client");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextPane();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        messageField = new JTextField();
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);

        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        loginPanel.add(new JLabel("Username:", SwingConstants.RIGHT));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.NORTH);
        setVisible(true);
        connectToServer();
    }

    private void connectToServer() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new IncomingReader()).start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to connect to the server. Please try again.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            connectToServer();
        }
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        out.println("LOGIN " + username + " " + password);
        passwordField.setText("");
    }

    private void addLogoutButton() {
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        loginPanel.setLayout(new BorderLayout());
        loginPanel.removeAll();
        loginPanel.add(logoutButton, BorderLayout.CENTER);
        loginPanel.revalidate();
        loginPanel.repaint();
    }

    private void logout() {
        try {
            out.println("LOGOUT");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        resetUIForLogin();
        connectToServer();
    }

    private void resetUIForLogin() {
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
        String message = messageField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            messageField.setText("");
        }
    }

    private void appendToChat(String message, boolean isServerMessage, boolean isSuccess) {
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
            doc.insertString(doc.getLength(), message + "\n", style);
            doc.setParagraphAttributes(doc.getLength(), 1, style, false);
            chatArea.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("LOGIN SUCCESS")) {
                        appendToChat(message, true, true);
                        SwingUtilities.invokeLater(() -> addLogoutButton());
                    } else if (message.startsWith("LOGIN FAILED")) {
                        appendToChat(message, true, false);
                    } else if (message.contains("betreten")) {
                        appendToChat(message, true, true);
                    } else if (message.contains("verlassen")) {
                        appendToChat(message, true, false);
                    } else {
                        appendToChat(message, false, false);
                    }
                }
            } catch (IOException e) {
                showError("Verbindung geschlossen.");
            }
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Client();
    }
}

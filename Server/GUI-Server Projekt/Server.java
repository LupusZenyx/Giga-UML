import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Server {
    private static final int PORT = 4711;
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
    private static final Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet();
    private static final Map<String, String> userCredentials = new HashMap<>();
    private static final Set<String> loggedInUsers = ConcurrentHashMap.newKeySet();
    private static volatile boolean running = true;
    private static volatile boolean shutdownMessagePrinted = false;
    private static ServerSocket serverSocket;
    private static ScheduledExecutorService executor;
    private static int maxClients;

    public static void main(String[] args) {
        setupLogger(); // Setup the logger
        loadUserCredentials(); // Load user credentials
        getMaxClientsFromUser(); // Get the maximum number of clients from the user

        try {
            startServer(); // Start the server
            monitorClientConnections(); // Monitor client connections
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            shutdownServer(); // Shutdown the server
        }
    }

    private static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("server.log", true);
            fileHandler.setFormatter(new SimpleFormatter() {
                private static final String format = "%s%n";

                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(format, lr.getMessage());
                }
            });
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUserCredentials() {
        // Load predefined user credentials
        userCredentials.put("user1", "pass");
        userCredentials.put("user2", "pass");
        userCredentials.put("user3", "pass");
        userCredentials.put("user4", "pass");
        userCredentials.put("admin", "adminpass");
    }

    private static void getMaxClientsFromUser() {
        // Get the maximum number of clients from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie die maximale Anzahl der Clients ein: ");
        maxClients = scanner.nextInt();
        scanner.close();
    }

    private static void startServer() throws IOException {
        // Start the server and schedule a task to print the number of logged-in users every 2 seconds
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server gestartet auf Port " + PORT);

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> System.out.println("Aktuell eingeloggte User: " + clientHandlers.size()), 0, 2, TimeUnit.SECONDS);
    }

    private static void monitorClientConnections() throws IOException {
        // Monitor client connections and accept new clients if the maximum number of clients is not reached
        while (running) {
            try {
                if (clientHandlers.size() < maxClients) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(new ClientHandler(clientSocket)).start();
                } else {
                    printMaxClientsReachedMessage();
                }
            } catch (SocketException e) {
                handleSocketException(e);
            }
        }
    }

    private static void printMaxClientsReachedMessage() {
        // Print a message when the maximum number of clients is reached
        if (!shutdownMessagePrinted) {
            System.out.println("Maximale Anzahl von Clients erreicht.");
            shutdownMessagePrinted = true;
        }
    }

    private static void handleSocketException(SocketException e) {
        // Handle socket exceptions
        if (!running && !shutdownMessagePrinted) {
            System.out.println("Server wurde heruntergefahren.");
            shutdownMessagePrinted = true;
        } else {
            e.printStackTrace();
        }
    }

    private static void shutdownServer() {
        // Shutdown the server and logout all users
        try {
            logoutAllUsers();
            closeServerSocket();
            shutdownExecutor();
            printShutdownMessage();
        } catch (IOException e) {
            System.out.println("Fehler beim Herunterfahren des Servers.");
            logger.severe("Fehler beim Herunterfahren des Servers: " + e.getMessage());
        } finally {
            closeLoggerFileHandler();
            System.exit(0);
        }
    }

    private static void logoutAllUsers() {
        // Logout all users and close their connections
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.out.println("LOGOUT - Server wird heruntergefahren");
            clientHandler.closeConnection();
        }
    }

    private static void closeServerSocket() throws IOException {
        // Close the server socket
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    }

    private static void shutdownExecutor() {
        // Shutdown the executor
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }
    }

    private static void printShutdownMessage() {
        // Print a shutdown message
        if (!shutdownMessagePrinted) {
            System.out.println("Server wurde heruntergefahren.");
            logger.info("Server wurde heruntergefahren.");
            shutdownMessagePrinted = true;
        }
    }

    private static void closeLoggerFileHandler() {
        // Close the logger file handler
        for (Handler handler : logger.getHandlers()) {
            if (handler instanceof FileHandler) {
                handler.close();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;
        private boolean loggedIn = false;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                setupStreams(); // Setup input and output streams
                handleLogin(); // Handle user login
                handleMessages(); // Handle incoming messages
            } catch (SocketException e) {
                handleSocketException(e);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection(); // Close the connection
            }
        }

        private void setupStreams() throws IOException {
            // Setup input and output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }

        private void handleLogin() throws IOException {
            // Handle user login
            while (true) {
                String loginMessage = in.readLine();
                if (loginMessage != null && loginMessage.startsWith("LOGIN ")) {
                    String[] loginParts = loginMessage.split(" ");
                    if (loginParts.length == 3) {
                        username = loginParts[1];
                        String password = loginParts[2];
                        if (clientHandlers.size() >= maxClients) {
                            out.println("LOGIN FAILED - Server is full");
                            closeConnection();
                            break;
                        }
                        if (authenticateUser(username, password)) {
                            break;
                        }
                    }
                }
            }
        }

        private boolean authenticateUser(String username, String password) {
            // Authenticate the user
            if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                synchronized (loggedInUsers) {
                    if (loggedInUsers.contains(username)) {
                        out.println("LOGIN FAILED - User already logged in");
                    } else {
                        loggedInUsers.add(username);
                        loggedIn = true;
                        out.println("LOGIN SUCCESS");
                        logUserLogin();
                        broadcast(username + " hat den Chat betreten.");
                        clientHandlers.add(this);
                        return true;
                    }
                }
            } else {
                out.println("LOGIN FAILED - Invalid credentials");
            }
            return false;
        }

        private void logUserLogin() {
            // Log user login
            String clientIP = socket.getInetAddress().getHostAddress();
            String loginTimestamp = dateFormat.format(new Date());
            logger.info("LOGIN - User: " + username + ", IP: " + clientIP + ", Time: " + loginTimestamp);
        }

        private void handleMessages() throws IOException {
            // Handle incoming messages
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("logout")) {
                    break;
                }
                if (isAdminShutdownCommand(message)) {
                    shutdownServer();
                    break;
                }
                broadcast(username + ": " + message);
            }
        }

        private boolean isAdminShutdownCommand(String message) {
            // Check if the message is an admin shutdown command
            if (username.equals("admin") && message.equals("SHUTDOWN")) {
                running = false;
                logAdminShutdown();
                return true;
            }
            return false;
        }

        private void logAdminShutdown() {
            // Log admin shutdown
            String clientIP = socket.getInetAddress().getHostAddress();
            String timestamp = dateFormat.format(new Date());
            logger.info("SHUTDOWN - User: " + username + ", IP: " + clientIP + ", Time: " + timestamp);
        }

        private void broadcast(String message) {
            // Broadcast a message to all logged-in users
            for (ClientHandler clientHandler : clientHandlers) {
                if (clientHandler.loggedIn) {
                    clientHandler.out.println(message);
                }
            }
        }

        private void closeConnection() {
            // Close the connection and remove the user from the logged-in users list
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
                if (username != null) {
                    synchronized (loggedInUsers) {
                        loggedInUsers.remove(username);
                    }
                    if (loggedIn) {
                        broadcast(username + " hat den Chat verlassen.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientHandlers.remove(this);
                shutdownMessagePrinted = false;
            }
        }
    }
}

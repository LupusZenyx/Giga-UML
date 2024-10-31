import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Server {
    private static final int PORT = 4711;
    private static Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet();
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Set<String> loggedInUsers = ConcurrentHashMap.newKeySet();
    private static int maxClients;
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
    private static volatile boolean running = true;
    private static ServerSocket serverSocket;
    private static ScheduledExecutorService executor;
    private static volatile boolean shutdownMessagePrinted = false;

    public static void main(String[] args) {
        setupLogger();
        loadUserCredentials();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie die maximale Anzahl der Clients ein: ");
        maxClients = scanner.nextInt();
        scanner.close();

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server gestartet auf Port " + PORT);

            executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(() -> System.out.println("Aktuell eingeloggte User: " + clientHandlers.size()), 0, 2, TimeUnit.SECONDS);

            while (running) {
                try {
                    if (clientHandlers.size() < maxClients) {
                        Socket clientSocket = serverSocket.accept();
                        ClientHandler clientHandler = new ClientHandler(clientSocket);
                        clientHandlers.add(clientHandler);
                        new Thread(clientHandler).start();
                    } else {
                        System.out.println("Maximale Anzahl von Clients erreicht.");
                    }
                } catch (SocketException e) {
                    if (!running && !shutdownMessagePrinted) {
                        System.out.println("Server wurde heruntergefahren.");
                        shutdownMessagePrinted = true;
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            shutdownServer();
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
        // Benutzername und Passwort hartcodieren
        userCredentials.put("user1", "pass");
        userCredentials.put("user2", "pass");
        userCredentials.put("user3", "pass");
        userCredentials.put("user4", "pass");
        userCredentials.put("admin", "adminpass");
    }

    private static void shutdownServer() {
        try {
            // Log out all users before shutdown
            for (ClientHandler clientHandler : clientHandlers) {
                clientHandler.out.println("LOGOUT - Server wird heruntergefahren");
                clientHandler.closeConnection();
            }
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if (executor != null && !executor.isShutdown()) {
                executor.shutdown();
            }
            if (!shutdownMessagePrinted) {
                System.out.println("Server wurde heruntergefahren.");
                logger.info("Server wurde heruntergefahren.");
                shutdownMessagePrinted = true;
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Herunterfahren des Servers.");
            logger.severe("Fehler beim Herunterfahren des Servers: " + e.getMessage());
        } finally {
            // Close the logger file handler
            for (Handler handler : logger.getHandlers()) {
                if (handler instanceof FileHandler) {
                    handler.close();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
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
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Handle login attempts
                while (true) {
                    String loginMessage = in.readLine();
                    if (loginMessage != null && loginMessage.startsWith("LOGIN ")) {
                        String[] loginParts = loginMessage.split(" ");
                        if (loginParts.length == 3) {
                            username = loginParts[1];
                            String password = loginParts[2];

                            if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                                synchronized (loggedInUsers) {
                                    if (loggedInUsers.contains(username)) {
                                        out.println("LOGIN FAILED - User already logged in");
                                    } else {
                                        loggedInUsers.add(username);
                                        loggedIn = true;
                                        out.println("LOGIN SUCCESS");
                                        String clientIP = socket.getInetAddress().getHostAddress();
                                        String loginTimestamp = dateFormat.format(new Date());
                                        logger.info("LOGIN - User: " + username + ", IP: " + clientIP + ", Time: " + loginTimestamp);
                                        broadcast(username + " hat den Chat betreten.");
                                        break; // Exit login loop on success
                                    }
                                }
                            } else {
                                out.println("LOGIN FAILED - Invalid credentials");
                            }
                        }
                    }
                }

                // Handle messages
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("logout")) {
                        break;
                    }
                    if (username.equals("admin") && message.equals("SHUTDOWN")) {
                        running = false;
                        String clientIP = socket.getInetAddress().getHostAddress();
                        String timestamp = dateFormat.format(new Date());
                        logger.info("SHUTDOWN - User: " + username + ", IP: " + clientIP + ", Time: " + timestamp);
                        shutdownServer();
                        break;
                    }
                    broadcast(username + ": " + message);
                }

            } catch (SocketException e) {
                if (!running && !shutdownMessagePrinted) {
                    System.out.println("Verbindung geschlossen.");
                    shutdownMessagePrinted = true;
                } else {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        private void broadcast(String message) {
            for (ClientHandler clientHandler : clientHandlers) {
                if (clientHandler.loggedIn) {
                    clientHandler.out.println(message);
                }
            }
        }

        private void closeConnection() {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
                clientHandlers.remove(this);
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
            }
        }
    }
}

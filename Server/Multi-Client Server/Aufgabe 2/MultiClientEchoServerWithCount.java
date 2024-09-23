import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiClientEchoServerWithCount {
    private static final int PORT = 7;
    private static boolean running = true;
    private static ExecutorService pool = Executors.newFixedThreadPool(10); 
    private static AtomicInteger clientCount = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(() -> {
            while (running) {
                System.out.println("Current connected clients: " + clientCount.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Multi-Client Echo Server started on port " + PORT);
            while (running) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientCount.incrementAndGet();
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                    pool.execute(new ClientHandler(clientSocket));
                } catch (IOException e) {
                    System.out.println("Error accepting client: " + e.getMessage());
                }
            }
        } catch (BindException e) {
            System.out.println("Port " + PORT + " already in use. Exiting...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("ende")) {
                        break;
                    }
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                    clientCount.decrementAndGet();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Client disconnected");
            }
        }
    }
}

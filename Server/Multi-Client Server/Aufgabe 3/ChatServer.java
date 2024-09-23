import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 7;
    private static Socket client1;
    private static Socket client2;

    public static void main(String[] args) {
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server started on port " + PORT);
            client1 = serverSocket.accept();
            System.out.println("Client 1 connected");
            client2 = serverSocket.accept();
            System.out.println("Client 2 connected");

            ExecutorService pool = Executors.newFixedThreadPool(2);
            pool.execute(new ClientHandler(client1, client2));
            pool.execute(new ClientHandler(client2, client1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private Socket otherClientSocket;

        public ClientHandler(Socket clientSocket, Socket otherClientSocket) {
            this.clientSocket = clientSocket;
            this.otherClientSocket = otherClientSocket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outOther = new PrintWriter(otherClientSocket.getOutputStream(), true)
            ) {
                String message;
                while ((message = in.readLine()) != null) {
                    outOther.println("Message from other client: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

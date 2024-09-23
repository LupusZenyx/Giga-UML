import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 2345; // The port on which the server will listen

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo server started and waiting for connections on port " + port);

            while (true) {
                // Waiting for a connection from the client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // A new thread for handling the client
                new Thread(new ClientHandler(clientSocket)).start();
            }

        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
            // InputStream and BufferedReader for reading data from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // OutputStream and BufferedWriter for sending data to the client
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            String receivedMessage;

            // Receiving and echoing the messages
            while ((receivedMessage = in.readLine()) != null) {
                System.out.println("Received message: " + receivedMessage);
                out.write(receivedMessage + "\n");
                out.flush();
                if (receivedMessage.equals("exit")) {
                    System.out.println("Client disconnected: " + clientSocket.getInetAddress());
                }
                if (receivedMessage.equals("yt")) {
                    String youtubeLink = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
                    String command = "open " + youtubeLink;
                    ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
                    processBuilder.start();
                }
                
            }

        } catch (IOException e) {
            System.err.println("Error processing the client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
}

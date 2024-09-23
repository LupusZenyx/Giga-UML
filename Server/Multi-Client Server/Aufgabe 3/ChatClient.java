import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 7;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            Thread receiveThread = new Thread(() -> {
                try {
                    String messageFromOtherClient;
                    while ((messageFromOtherClient = in.readLine()) != null) {
                        System.out.println(messageFromOtherClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            String userInput;
            System.out.println("Connected to the server. Type your message:");
            while (true) {
                System.out.print("Message: ");
                userInput = consoleInput.readLine();

                if (userInput.equalsIgnoreCase("ende")) {
                    break;
                }

                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Connection closed.");
    }
}

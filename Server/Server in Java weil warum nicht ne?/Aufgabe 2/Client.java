import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int port = 2345; // Port on which the server is listening

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server. Enter messages:");

            String userInput = null;
            while (true) {
                System.out.print("Message: ");
                userInput = scanner.nextLine();
                
                out.write(userInput + "\n");
                out.flush();
                if ("exit".equalsIgnoreCase(userInput)) {
                    System.out.println("Connection Closed at " + serverAddress);
                    break;
                }
                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);

                
            }

        } catch (IOException e) {
            System.err.println("Error communicating with the server: " + e.getMessage());
        }
    }
}

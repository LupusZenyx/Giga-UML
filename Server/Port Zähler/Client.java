
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Verbindung zum Server " + serverAddress + " auf Port " + port + " hergestellt.");

        } catch (IOException e) {
            System.err.println("Fehler bei der Verbindung zum Server: " + e.getMessage());
        }

        System.out.println("Verbindung geschlossen.");
    }
}

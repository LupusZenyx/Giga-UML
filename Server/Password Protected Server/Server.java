import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String CORRECT_PASSWORD = "geheim";
    
    public static void main(String[] args) {
        int port = 8080; 
        
        try {
            @SuppressWarnings("resource")
            ServerSocket serverSocket = new ServerSocket(port); 
            System.out.println("Server gestartet. Warte auf Verbindungen...");
            
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client verbunden: " + clientSocket.getInetAddress().getHostAddress());
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    
                    out.println("Bitte Passwort eingeben.");
                    
                    String clientPassword = in.readLine();
                    
                    if (clientPassword != null && clientPassword.equals(CORRECT_PASSWORD)) {
                        System.out.println("Richtiges Passwort von Client.");
                        out.println("Jo sheesh krass, richtiges Passwort.");
                    } else {
                        System.out.println("Falsches Passwort von Client.");
                        out.println("Falsches Passwort.");
                    }
                    
                    clientSocket.close();
                    System.out.println("Verbindung zu Client getrennt.");
                    
                } catch (IOException e) {
                    System.err.println("Fehler beim Verarbeiten der Client-Verbindung: " + e.getMessage());
                }
            }
            
        } catch (IOException e) {
            System.err.println("Fehler beim Starten des Servers: " + e.getMessage());
            System.exit(1); 
        }
    }
}

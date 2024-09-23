import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleServer {
    
    // Pfad zur Log-Datei
    private static final String LOG_FILE = "client_connections.log";
    
    public static void main(String[] args) {
        int port = 8080; // Der Server lauscht auf diesem Port
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server gestartet. Warte auf Clients...");
            
            // Endlosschleife, in der der Server auf neue Clients wartet
            while (true) {
                try {
                    // Akzeptiere die Verbindung eines Clients
                    Socket clientSocket = serverSocket.accept();
                    
                    // Hole die IP-Adresse des Clients
                    String clientIP = clientSocket.getInetAddress().getHostAddress();
                    
                    // Erstelle ein Zeitstempel-Format
                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    
                    // Speichere die Verbindungsdaten in der Datei
                    saveConnectionData(clientIP, timeStamp);
                    
                    // Simuliere den Datenaustausch (hier eine Sekunde Pause)
                    System.out.println("Verbindung zu " + clientIP + " hergestellt. Daten werden gespeichert.");
                    Thread.sleep(1000);
                    
                    // Schließe die Verbindung
                    clientSocket.close();
                    System.out.println("Verbindung zu " + clientIP + " getrennt.");
                    
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Starten des Servers: " + e.getMessage());
        }
    }

    // Methode zum Speichern der Verbindungsdaten in einer Textdatei
    private static void saveConnectionData(String clientIP, String timeStamp) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(LOG_FILE, true)))) {
            // Schreibe die Verbindungsdaten in der Dotted-Quad-Notation in die Datei
            out.println("Client IP: " + clientIP + ", Zeitpunkt: " + timeStamp);
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Verbindungsdaten: " + e.getMessage());
        }
    }
}

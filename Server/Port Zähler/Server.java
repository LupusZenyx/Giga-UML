
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        int port = 12345;
        String logFile = "/Volumes/home/_PRIN/_Q3/Thema 2/src/Seite5/Zusatz/connections.log";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server gestartet und lauscht auf Port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                String clientIP = clientSocket.getInetAddress().getHostAddress();

                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                    writer.write("Client IP: " + clientIP + ", Verbindungszeit: " + timeStamp);
                    writer.newLine();
                    System.out.println("Verbindung von " + clientIP + " um " + timeStamp + " gespeichert.");
                } catch (IOException e) {
                    System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                clientSocket.close();
                System.out.println("Verbindung zu " + clientIP + " geschlossen.");
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Erstellen des Servers: " + e.getMessage());
        }
    }
}

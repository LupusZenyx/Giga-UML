import java.io.*;
import java.net.*;

public class Server {
    private int port;
    private String passwort1;
    private String passwort2;

    public Server(int port, String passwort1, String passwort2) {
        this.port = port;
        this.passwort1 = passwort1;
        this.passwort2 = passwort2;
    }

    public void starten() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server gestartet. Warte auf Verbindung...");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Verbindung hergestellt.");

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                out.write("Bitte Passwort eingeben.");
                out.newLine();
                out.flush();

                String clientPassword = in.readLine();

                if (passwort1.equals(clientPassword)) {
                    System.out.println("Richtiges Passwort eingegeben. Sende Treffpunkt...");
                    out.write("Treff morgen 12:00 bei Marie Niert.");
                    out.newLine();
                } else if (passwort2.equals(clientPassword)) {
                    System.out.println("Richtiges Passwort eingegeben. Server wird heruntergefahren.");
                    out.write("Server wird heruntergefahren.");
                    out.newLine();
                    out.flush();
                    in.close();
                    out.close();
                    socket.close();
                    serverSocket.close();
                    break;
                } else {
                    System.out.println("Falsches Passwort eingegeben.");
                    out.write("Falsches Passwort.");
                    out.newLine();
                }
                out.flush();

                in.close();
                out.close();
                socket.close();
                System.out.println("Verbindung zum Client beendet.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

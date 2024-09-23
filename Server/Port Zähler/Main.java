import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class PortScanner {
    public boolean scannen(int port) {
        try (Socket socket = new Socket("localhost", port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PortScanner portScanner = new PortScanner();

        System.out.print("Bitte geben Sie den Startport ein: ");
        int startPort = scanner.nextInt();

        System.out.print("Bitte geben Sie den Endport ein: ");
        int endPort = scanner.nextInt();

        System.out.println("Scanne Ports von " + startPort + " bis " + endPort + "...");
        for (int port = startPort; port <= endPort; port++) {
            if (portScanner.scannen(port)) {
                System.out.println("Port " + port + " ist belegt.");
            } else {
                System.out.println("Port " + port + " ist nicht belegt.");
            }
        }

        scanner.close();
    }
}

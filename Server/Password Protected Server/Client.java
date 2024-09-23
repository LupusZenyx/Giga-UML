import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) {
        String serverAddress = "localhost"; 
        int port = 8080; 
        
        try {
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Mit dem Server verbunden.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            
            String serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);
            
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Bitte Passwort eingeben: ");
            String password = userInput.readLine();
            
            out.println(password);
            
            String response = in.readLine();
            System.out.println("Server: " + response);
            
            socket.close();
            System.out.println("Verbindung zum Server geschlossen.");
            
        } catch (IOException e) {
            System.err.println("Fehler bei der Verbindung zum Server: " + e.getMessage());
        }
    }
}

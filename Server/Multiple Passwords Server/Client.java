import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
          
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Mit dem Server verbunden.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);

            System.out.print("Bitte Passwort eingeben: ");
            String password = userInput.readLine();
            out.write(password);
            out.newLine();
            out.flush();

            String response = in.readLine();
            System.out.println("Server: " + response);

            in.close();
            out.close();
            socket.close();
            System.out.println("Verbindung zum Server geschlossen.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

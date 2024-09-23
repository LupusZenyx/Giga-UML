public class ServerMain {
    public static void main(String[] args) {
        int port = 1234;
        String passwort1 = "helge";
        String passwort2 = "schneider";
        
        Server server = new Server(port, passwort1, passwort2);
        server.starten();
    }
}

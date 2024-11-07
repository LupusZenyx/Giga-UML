import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SocialMediaPlatform {
    private List<Nutzer> nutzerListe;

    public SocialMediaPlatform() {
        this.nutzerListe = new ArrayList<>();
    }

    public void registrieren(String name, String email, String passwort) {
        Nutzer neuerNutzer = new Nutzer(name, email, passwort);
        nutzerListe.add(neuerNutzer);
    }

    public Nutzer anmelden(String email, String passwort) {
        for (Nutzer nutzer : nutzerListe) {
            if (nutzer.getEmail().equals(email) && nutzer.getPasswort().equals(passwort)) {
                return nutzer;
            }
        }
        return null; 
    }

    public char[] generierePasswort() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        char[] passwort = new char[8];
        for (int i = 0; i < 8; i++) {
            passwort[i] = chars.charAt(rnd.nextInt(chars.length()));
        }
        return passwort;
    }

    public List<Nutzer> ermittleAbonnierteNutzerMitNeuenBeitraegen(Nutzer nutzer) {
        List<Nutzer> abonnierteNutzerMitNeuenBeitraegen = new ArrayList<>();
        // Implement logic to find subscribed users with new posts
        return abonnierteNutzerMitNeuenBeitraegen;
    }

    public Nutzer sucheNutzer(String name) {
        for (Nutzer nutzer : nutzerListe) {
            if (nutzer.getName().equals(name)) {
                return nutzer;
            }
        }
        return null; 
    }
}

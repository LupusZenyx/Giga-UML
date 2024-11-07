import java.util.ArrayList;
import java.util.List;

public class Nutzer {

    private String name;
    private String email;
    private String passwort;
    private DateTime zuletztAktiv;
    private String titel;
    private String text;
    private Bild bild;
    private List<Nutzer> abonnierteNutzer;
    private List<Beitrag> beitraege;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public DateTime getZuletztAktiv() {
        return zuletztAktiv;
    }

    public String getTitel() {
        return titel;
    }

    public String getText() {
        return text;
    }

    public Bild getBild() {
        return bild;
    }

    public Nutzer(String name, String email, String passwort) {
        this.name = name;
        this.email = email;
        this.passwort = passwort;
        this.zuletztAktiv = new DateTime();
        this.abonnierteNutzer = new ArrayList<>();
        this.beitraege = new ArrayList<>();
    }

    public void erstelleBeitrag(String titel, Bild bild) {
        Beitrag neuerBeitrag = new Beitrag(this, titel, bild);
        beitraege.add(neuerBeitrag);
    }

    public void erstelleBeitrag(String titel, String text, Bild bild) {
        Beitrag neuerBeitrag = new Beitrag(this, titel, bild);
        neuerBeitrag.erstelleText(text);
        beitraege.add(neuerBeitrag);
    }

    public void abonnieren(Nutzer nutzer) {
        if (!abonnierteNutzer.contains(nutzer)) {
            abonnierteNutzer.add(nutzer);
        }
    }

    public void like(Beitrag beitrag) {
        beitrag.like(this);
    }

    public void hinzufuegenBild(Bild bild) {
        this.bild = bild;
    }
}
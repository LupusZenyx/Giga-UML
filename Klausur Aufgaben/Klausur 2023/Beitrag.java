public class Beitrag {
    private DateTime gepostet;
    private String titel;
    private int anzahlLikes;
    private String text;
    private Bild bild;

    public DateTime getGepostet() {
        return gepostet;
    }

    public String getTitel() {
        return titel;
    }

    public int getAnzahlLikes() {
        return anzahlLikes;
    }

    public Beitrag(Nutzer author, String titel, Bild bild) {
        this.gepostet = new DateTime();
        this.titel = titel;
        this.bild = bild;
        author.erstelleBeitrag(titel, bild);
    }

    public void hinzufuegenBild(Bild bild) {
        this.bild = bild;
    }

    public void like(Nutzer nutzer) {
        this.anzahlLikes++;
    }

    public void erstelleText(String text) {
        this.text = text;
    }
}

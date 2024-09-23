public class Kunde {

    private int kundennummer;
    private String nachname;

    public Kunde(int kundennummer, String nachname) {
        this.kundennummer = kundennummer;
        this.nachname = nachname;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public String getNachname() {
        return nachname;
    }



}

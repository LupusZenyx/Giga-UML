public class Monatsverbrauch {
    private int verbraucherNr;
    private int monatsnummer;
    private int verbrauch;

    public Monatsverbrauch(int verbraucherNr, int monatsnummer, int verbrauch) {
        this.verbraucherNr = verbraucherNr;
        this.monatsnummer = monatsnummer;
        this.verbrauch = verbrauch;
    }

    public int getVerbraucherNr() {
        return verbraucherNr;
    }

    public void setVerbraucherNr(int verbraucherNr) {
        this.verbraucherNr = verbraucherNr;
    }

    public int getMonatsnummer() {
        return monatsnummer;
    }

    public void setMonatsnummer(int monatsnummer) {
        this.monatsnummer = monatsnummer;
    }

    public int getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(int verbrauch) {
        this.verbrauch = verbrauch;
    }
}

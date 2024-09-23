class Kunde {
    private String vorname;
    private String nachname;

    public Kunde(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String toString() {
        return vorname + " " + nachname;
    }
}

public class Kundensortierung {

    public static void main(String[] args) {
        Kunde[] kunden = {
                new Kunde("Max", "Mustermann"),
                new Kunde("Anna", "Schmidt"),
                new Kunde("Peter", "Schulz"),
                new Kunde("Paula", "Weber"),
                new Kunde("Eva", "Keller")
        };

        customersorten(kunden);
        System.out.println("Sortierte Kunden:");
        for (Kunde kunde : kunden) {
            System.out.println(kunde);
        }
    }

    public static void customersorten(Kunde[] kunden) {
        for (int i = 0; i < kunden.length - 1; i++) {
            int minimalerIndex = i;
            for (int j = i + 1; j < kunden.length; j++) {
                if (kunden[j].toString().compareTo(kunden[minimalerIndex].toString()) < 0) {
                    minimalerIndex = j;
                }
            }
            Kunde temp = kunden[i];
            kunden[i] = kunden[minimalerIndex];
            kunden[minimalerIndex] = temp;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Array Array = new Array();
        Kunde k1 = new Kunde(233, "Schroedinger");
        Kunde k2 = new Kunde(235, "Einstein");
        Kunde k3 = new Kunde(236, "Newton");
        Kunde k4 = new Kunde(237, "Heisenberg");

        Kunde[] kunden = new Kunde[]{k1, k2, k3, k4};

        Kunde kunde = Array.search(kunden, 236);

        // Kundennummer ausgeben
        if (kunde != null) {
            System.out.println("Kunde gefunden: " + kunde.getNachname());
        } else {
            System.out.println("Kunde nicht gefunden");
        }

    }
}
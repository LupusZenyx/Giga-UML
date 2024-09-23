public class Main {

    public static void main(String[] args) {
        // Array initialisieren
        int[] array = { 1, 3, 5, 2, 4 };

        // Aufsteigend sortieren
        int[] sortiert = ArrayVerwaltung.sortieren(array, true);

        // Ergebnis ausgeben
        System.out.println("Aufsteigend sortiert:");
        for (int j : sortiert) {
            System.out.println(j);
        }

        // Absteigend sortieren
        ArrayVerwaltung.sortieren(array, false);

        // Ergebnis ausgeben
        System.out.println("\nAbsteigend sortiert:");
        for (int j : sortiert) {
            System.out.println(j);
        }
    }
}
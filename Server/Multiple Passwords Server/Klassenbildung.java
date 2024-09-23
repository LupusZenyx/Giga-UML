import java.util.Scanner;

public class Klassenbildung {
    public static void main(String[] args) {
        int schuelerAnzahl, klassenStaerke, anzahlKlassen, uebrigeSchueler;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Wie viele Schüler wurden aufgenommen: ");
        schuelerAnzahl = scanner.nextInt();
        
        System.out.print("Klassenstärke: ");
        klassenStaerke = scanner.nextInt();
        
        anzahlKlassen = schuelerAnzahl / klassenStaerke;
        uebrigeSchueler = schuelerAnzahl % klassenStaerke;
        
        System.out.println("Es sind " + anzahlKlassen + " Klassen mit je " + klassenStaerke + " Schülern zu bilden.");
        System.out.println(uebrigeSchueler + " Schüler bleiben übrig.");
        
        boolean ergebnis = (uebrigeSchueler == 0);
        System.out.println("Können alle Schüler zugeteilt werden: " + (ergebnis ? "true" : "false"));
        
        scanner.close();
    }
}

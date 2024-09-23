import java.util.Arrays;
public class PruefID {

    public static boolean pruefID(String id) {
        // Prüfen, ob die ID die richtige Länge hat
        if (id.length() != 10) {
            return false;
        }

        // Ziffern der ID in ein Array kopieren
        char[] digits = id.toCharArray();

        // Multiplikation der Ziffern an ungerader Stelle mit 2
        int[] mult = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 1) {
                mult[i] = (digits[i] - '0') * 2;
            } else {
                mult[i] = digits[i] - '0';
            }
        }

        // Bildung der Quersummen aller entstandenen Produkte
        int[] sums = new int[mult.length / 2];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = mult[2 * i] + mult[2 * i + 1];
        }

        // Addition der Ziffern an gerader Stelle
        int sum = 0;
        for (int i = 1; i < digits.length; i += 2) {
            sum += digits[i] - '0';
        }

        // Addition der Ergebnisse aus den Schritten 2 und 3
        int result = sum + Arrays.stream(sums).sum();

        // Aufrundung des Ergebnisses auf die nächstgrößere durch 10 teilbare Zahl
        if (result % 10 != 0) {
            result += 10;
        }

        // Berechnung der Differenz aus dem Ergebnis aus Schritt 5 und dem Ergebnis aus Schritt 4
        int pz = result - sum;

        // Vergleich der letzten Ziffer der ID-Card-Nummer mit der errechneten Prüfziffer
        return digits[9] - '0' == pz;
    }

    public static void main(String[] args) {
        // Testfälle
        System.out.println(pruefID("6258431979")); // true
        System.out.println(pruefID("1234567890")); // false
        System.out.println(pruefID("1234567891")); // false
    }
}

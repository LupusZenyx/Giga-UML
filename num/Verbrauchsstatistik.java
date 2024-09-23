import java.util.ArrayList;
import java.util.List;

public class Verbrauchsstatistik {
    public static Jahresstatistik statistik(int[][] verbrauch, int limit) {

        // Minimalen und maximalen Monatsverbrauch über alle Verbraucher hinweg berechnen.
        int minVerbrauch = Integer.MAX_VALUE;
        int maxVerbrauch = Integer.MIN_VALUE;
        for (int i = 0; i < verbrauch.length; i++) {
            for (int j = 1; j < verbrauch[i].length; j++) {
                minVerbrauch = Math.min(minVerbrauch, verbrauch[i][j]);
                maxVerbrauch = Math.max(maxVerbrauch, verbrauch[i][j]);
            }
        }

        // Liste der Verbraucher erstellen, die in einem Monat den vorgegebenen Schwellenwert überschritten haben.
        List<Monatsverbrauch> limitVerbraucher = new ArrayList<>();
        for (int i = 0; i < verbrauch.length; i++) {
            for (int j = 1; j < verbrauch[i].length; j++) {
                if (verbrauch[i][j] > limit) {
                    limitVerbraucher.add(new Monatsverbrauch(i, j, verbrauch[i][j]));
                }
            }
        }

        // Jahresstatistik-Objekt zurückgeben.
        return new Jahresstatistik(minVerbrauch, maxVerbrauch, limitVerbraucher);

    }

    public static void main(String[] args) {
        int[][] verbrauch = new int[][]{
                {1001, 23, 28, 31, 35, 42, 45, 47, 50, 56, 61, 67, 73},
                {1002, 25, 29, 33, 37, 42, 46, 49, 53, 58, 62, 66, 72},
                {5999, 24, 30, 34, 40, 44, 48, 55, 62, 66, 71, 77, 82}
        };
        int limit = 50;

        Jahresstatistik statistik = statistik(verbrauch, limit);

        System.out.println("Minimaler Monatsverbrauch: " + statistik.getMinVerbrauch());
        System.out.println("Maximaler Monatsverbrauch: " + statistik.getMaxVerbrauch());

        for (Monatsverbrauch verbraucher : statistik.getLimitVerbraucher()) {
            System.out.println(verbraucher);
        }
    }
}
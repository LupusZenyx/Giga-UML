import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jahresstatistik {

    private int minVerbrauch;
    private int maxVerbrauch;
    private List<Monatsverbrauch> limitVerbraucher;

    public Jahresstatistik(int minVerbrauch, int maxVerbrauch, List<Monatsverbrauch> limitVerbraucher) {
        this.minVerbrauch = minVerbrauch;
        this.maxVerbrauch = maxVerbrauch;
        this.limitVerbraucher = limitVerbraucher;
    }

    public int getMinVerbrauch() {
        return minVerbrauch;
    }

    public void setMinVerbrauch(int minVerbrauch) {
        this.minVerbrauch = minVerbrauch;
    }

    public int getMaxVerbrauch() {
        return maxVerbrauch;
    }

    public void setMaxVerbrauch(int maxVerbrauch) {
        this.maxVerbrauch = maxVerbrauch;
    }

    public List<Monatsverbrauch> getLimitVerbraucher() {
        return limitVerbraucher;
    }

    public void setLimitVerbraucher(List<Monatsverbrauch> limitVerbraucher) {
        this.limitVerbraucher = limitVerbraucher;
    }

    public static Jahresstatistik statistik(int[][] verbrauch, int limit) {
        int minVerbrauch = Integer.MAX_VALUE;
        int maxVerbrauch = Integer.MIN_VALUE;
        List<Monatsverbrauch> limitVerbraucher = new ArrayList<>();

        for (int i = 1; i < verbrauch.length; i++) {
            int[] verbraucherDaten = verbrauch[i];
            int minMonatsverbrauch = Integer.MAX_VALUE;
            int maxMonatsverbrauch = Integer.MIN_VALUE;
            int limitUeberschritten = 0;

            for (int j = 2; j < verbraucherDaten.length; j++) {
                int verbrauch = verbraucherDaten[j];
                minMonatsverbrauch = Math.min(minMonatsverbrauch, verbrauch);
                maxMonatsverbrauch = Math.max(maxMonatsverbrauch, verbrauch);

                if (verbrauch > limit) {
                    limitUeberschritten++;
                }
            }

            if (limitUeberschritten > 0) {
                limitVerbraucher.add(new Monatsverbrauch(verbraucherDaten[0], limitUeberschritten, maxMonatsverbrauch));
            }

            minVerbrauch = Math.min(minVerbrauch, minMonatsverbrauch);
            maxVerbrauch = Math.max(maxVerbrauch, maxMonatsverbrauch);
        }

        return new Jahresstatistik(minVerbrauch, maxVerbrauch, limitVerbraucher);
    }
}


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
}
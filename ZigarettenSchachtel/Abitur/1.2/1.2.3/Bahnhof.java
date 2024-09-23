public class Bahnhof {
    private Gleis[] gleise;

    public Bahnhof(Gleis[] gleise) {
        this.gleise = gleise;
    }

    public void rangieren(Waggon waggon, Gleis vonGleis, Gleis nachGleis) {
        if (vonGleis.isEmpty()) {
            throw new IllegalArgumentException("Das Gleis ist leer.");
        }

        nachGleis.abstellen(waggon);
        vonGleis.entnehmen();
    }

    public void umordnen() {
        
    }
}
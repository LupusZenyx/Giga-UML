public class Gleis {
    private Waggon ersterWaggon;

    public void abstellen(Waggon waggon) {
        waggon.naechsterWaggon = ersterWaggon;
        ersterWaggon = waggon;
    }

    public Waggon entnehmen() {
        if (ersterWaggon == null) {
            return null;
        }

        Waggon waggon = ersterWaggon;
        ersterWaggon = ersterWaggon.naechsterWaggon;
        return waggon;
    }

    public boolean isEmpty() {
        return ersterWaggon == null;
    }
}


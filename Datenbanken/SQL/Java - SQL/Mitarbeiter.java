public class Mitarbeiter {
    private int id;
    private String nachname;
    private String vorname;

    public Mitarbeiter(int id, String nachname, String vorname) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public int getId() {
        return id;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{id=" + id + ", nachname='" + nachname + "', vorname='" + vorname + "'}";
    }
}

public class Bild {
    private int id;
    private int autowert;
    private String dateiname;

    public Bild(String dateiname) {
        this.dateiname = dateiname;
    }

    public int getId() {
        return id;
    }

    public int getAutowert() {
        return autowert;
    }

    public String getDateiname() {
        return dateiname;
    }
}

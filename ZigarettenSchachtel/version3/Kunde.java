import java.util.ArrayList;
import java.util.List;

public class Kunde
{
    private int nummer;
    private String nachname;
    private Kunde nachfolger;

    public Kunde(int nummer, String nachname)
    {
        this.nummer = nummer;
        this.nachname = nachname;
    }

    public int getNummer()
    {
        return nummer;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void setNachfolger(Kunde nachfolger)
    {
        this.nachfolger = nachfolger;
    }

    public Kunde getNachfolger()
    {
        return nachfolger;
    }

    public int getUmsatz()
    {
        int umsatz = 0;

        for (Bestellung bestellung : bestellungen)
        {
            umsatz += bestellung.getPreis();
        }

        return umsatz;
    }

    private List<Bestellung> bestellungen = new ArrayList<>();

    public void addBestellung(Bestellung bestellung)
    {
        bestellungen.add(bestellung);
    }

    public void setVorgaenger(Object object) {
    }

    public Kunde getVorgaenger() {
        return null;
    }
}

import java.util.Iterator;

public class Kundenliste implements Iterable<Kunde>
{
    private int anzahl = 0;
    private Kunde erster;

    public Kundenliste()
    {
    }

    public Kunde getErster()
    {
        return erster;
    }

    public Kunde getLetzter()
    {
        if (erster == null)
        {
            return null;
        }

        Kunde aktueller = erster;
        while (aktueller.getNachfolger() != null)
        {
            aktueller = aktueller.getNachfolger();
        }
        return aktueller;
    }

    public int getAnzahl()
    {
        return anzahl;
    }

    @Override
    public Iterator<Kunde> iterator()
    {
        return new KundenlisteIterator(erster);
    }

    private class KundenlisteIterator implements Iterator<Kunde>
    {
        private Kunde aktueller;

        public KundenlisteIterator(Kunde erster)
        {
            aktueller = erster;
        }

        @Override
        public boolean hasNext()
        {
            return aktueller != null;
        }

        @Override
        public Kunde next()
        {
            Kunde kunde = aktueller;
            aktueller = aktueller.getNachfolger();
            return kunde;
        }
    }

    public void einfuegenAnfang(Kunde kunde) {
        if (erster == null) {
            erster = kunde;
        } else {
            kunde.setNachfolger(erster);
            erster = kunde;
        }
        anzahl++;
    }

    public void einfuegenEnde(Kunde kunde) {
        if (erster == null) {
            erster = kunde;
        } else {
            Kunde aktueller = erster;
            while (aktueller.getNachfolger() != null) {
                aktueller = aktueller.getNachfolger();
            }
            aktueller.setNachfolger(kunde);
        }
        anzahl++;
    }

    public Kunde suchen(int kundennummer) {
        Kunde aktueller = erster;
        while (aktueller != null && aktueller.getNummer() != kundennummer) {
            aktueller = aktueller.getNachfolger();
        }
        return aktueller;
    }

    public boolean loeschen(int kundennummer) {
        if (erster == null) {
            return false;
        } else if (erster.getNummer() == kundennummer) {
            erster = erster.getNachfolger();
            anzahl--;
            return true;
        } else {
            Kunde aktueller = erster;
            while (aktueller.getNachfolger() != null && aktueller.getNachfolger().getNummer() != kundennummer) {
                aktueller = aktueller.getNachfolger();
            }
            if (aktueller.getNachfolger() == null) {
                return false;
            } else {
                aktueller.setNachfolger(aktueller.getNachfolger().getNachfolger());
                anzahl--;
                return true;
            }
        }
    }

    public void ausgebenTestliste() {
    }

    public void erzeugenTestliste() {
    }
}
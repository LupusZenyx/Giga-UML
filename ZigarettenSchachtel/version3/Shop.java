public class Shop
{
    private Kundenliste kundenliste;

    public Shop()
    {
        kundenliste = new Kundenliste();
    }

    public void erzeugenTestliste()
    {
        Kunde kunde1 = new Kunde(4711, "Meier");
        Kunde kunde2 = new Kunde(4766, "Lehmann");
        Kunde kunde3 = new Kunde(4722, "Schulze");
        kundenliste.einfuegenAnfang(kunde1);
        kundenliste.einfuegenEnde(kunde2);
        kundenliste.einfuegenEnde(kunde3);
    }

    public void ausgebenErsterTestliste()
    {
        if (kundenliste.getAnzahl() == 0)
        {
            return;
        }

        Kunde kunde = kundenliste.getErster();

        do
        {
            System.out.println(kunde.getNummer() + " " + kunde.getNachname());
            kunde = kunde.getNachfolger();
        }
        while (kunde != null);
    }

    public void ausgebenLetzterTestliste()
        {
            if (kundenliste.getAnzahl() == 0)
            {
                return;
            }

            Kunde kunde = kundenliste.getLetzter();

            do
            {
                System.out.println(kunde.getNummer() + " " + kunde.getNachname());
                kunde = kunde.getNachfolger();
            }
            while (kunde != null);
        }
    
    public void bestellen(int kundennummer, int preis)
    {
        Kunde kunde = kundenliste.suchen(kundennummer);
        if (kunde == null)
        {
            throw new IllegalArgumentException("Kundennummer nicht gefunden");
        }

        kunde.addBestellung(new Bestellung(preis));
    }

    public int getUmsatz()
    {
        int umsatz = 0;

        for (Kunde kunde : kundenliste)
        {
            umsatz += kunde.getUmsatz();
        }

        return umsatz;
    }
}

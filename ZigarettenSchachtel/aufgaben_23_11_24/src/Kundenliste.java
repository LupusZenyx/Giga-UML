public class Kundenliste {
    private Kunde erster = null;
    private int anzahl = 0;

    public void erzeugenTestliste() {
        Kunde kunde1 = new Kunde(4711, "Meier");
        Kunde kunde2 = new Kunde(4766, "Lehmann");
        Kunde kunde3 = new Kunde(4722, "Schulze");
        erster = kunde1;
        kunde1.setNachfolger(kunde2);
        kunde2.setNachfolger(kunde3);
        kunde1.setVorgaenger(null);
        kunde2.setVorgaenger(kunde1);
        kunde3.setVorgaenger(kunde2);
        System.out.println("Anzahl: " + getAnzahl());
        einfuegenAnfang(new Kunde(4712, "Meyer"));
        System.out.println("Anzahl: " + getAnzahl());
        einfuegenEnde(new Kunde(4713, "Mayer"));
        System.out.println("Anzahl: " + getAnzahl());
        System.out.println(suchen(4712).getNachname());
        System.out.println(loeschen(4712));
        System.out.println(suchen(4712));
        System.out.println("Anzahl: " + getAnzahl());
    }

    public void ausgebenTestliste() {
        if (erster == null) {
            return;
        }

        Kunde kunde = erster;

        do {
            System.out.println(kunde.getNummer() + " " + kunde.getNachname());
            kunde = kunde.getNachfolger();
        }
        while (kunde != null);
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void einfuegenAnfang(Kunde kunde) {
        if (erster == null) {
            erster = kunde;
            kunde.setNachfolger(null);
            kunde.setVorgaenger(null);
        } else {
            kunde.setNachfolger(erster);
            erster.setVorgaenger(kunde);
            erster = kunde;
        }
        anzahl++;
    }

    public void einfuegenEnde(Kunde kunde) {
        if (erster == null) {
            erster = kunde;
            kunde.setNachfolger(null);
            kunde.setVorgaenger(null);
        } else {
            Kunde aktueller = erster;
            while (aktueller.getNachfolger() != null) {
                aktueller = aktueller.getNachfolger();
            }
            aktueller.setNachfolger(kunde);
            kunde.setVorgaenger(aktueller);
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
            if (erster.getNachfolger() != null) {
                erster.getNachfolger().setVorgaenger(null);
            }
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
                Kunde vorgaenger = aktueller.getNachfolger().getVorgaenger();
                if (vorgaenger != null) {
                    vorgaenger.setNachfolger(aktueller.getNachfolger().getNachfolger());
                }
                aktueller.getNachfolger().setVorgaenger(null);
                aktueller.setNachfolger(null);
                anzahl--;
                return true;
            }
        }
    }
}
# Datenbank für das Carsharing-Unternehmen
## Aufgabe 2.1
Mitglied (<u>mitgliedsnr</u>, name, vorname)
Fahrzeug (<u>kennzeichen</u>, hersteller, baujahr, kmStand, bezeichnung#)
Fahrzeugklasse (<u>bezeichnung</u>, preisProKm, preisProMin)
Buchung (nutzungsBeginn, nutzungsEnde, mitgliedsnr#, Fharzeugklasse#)

## Aufgabe 2.3
## Untersuchung des relationalen Modells auf die 3. Normalform

- transitive Abhängigkeit 

**Buchung.fahrzeugklasse#** -> **Fahrzeugklasse.preisProKm**

verursacht eine Anomalie, da sich der Preis pro Kilometer bei einer Änderung der 
Fahrzeugklasse nicht nur in der Tabelle **Fahrzeugklasse**, sondern auch in allen 
Datensätzen der Tabelle **Buchung** ändern muss.


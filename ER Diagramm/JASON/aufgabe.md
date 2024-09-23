# JASON ER-Diagramm
## Aufgabe 1

### Mitglied:
Attribut | Datentyp
--- | ---
Vorname	| VARCHAR(30)
Nachname | VARCHAR(30)
<u>Mitglied_ID</u> | INT
Geburtsdatum | DATE
Geburtsdatum_Anzeige | BOOLEAN
Freunde_Anzahl | INT

### Gruppe:
Attribut | Datentyp
--- | ---
Gruppen_ID | INT
Name | VARCHAR()
Gründungsdatum | DATE

### Nachricht:
Attribut | Datentyp
--- | ---
Nachricht_ID | INT
Inhalt | VARCHAR()
Datum_Uhrzeit | DATETIME
Sender_ID | INT
Empfänger_ID | INT

### Statusmeldung:
Attribut | Datentyp
--- | ---
Statusmeldung_ID | INT
Inhalt | VARCHAR()
Datum_Uhrzeit | DATETIME
Mitglied_ID | INT


### Diagramm:

![alt text](<Screenshot 2024-03-15 at 12.07.18.png>)
chen schreibweise weil jolo mach halt


## Aufgabe 2

Mitglied(<u>Mitglied_ID</u>, Vorname, Nachname, Geburtsdatum, Geburtsdatum_Anzeige)

Gruppe(<u>Gruppen_ID</u>, Name, Gründungsdatum, #Mitglied_ID)

Nachricht(<u>Nachricht_ID</u>, Inhalt, Datum_Uhrzeit, #Sender_ID, #Empfänger_ID)

Statusmeldung(<u>Statusmeldung_ID</u>, Inhalt, Datum_Uhrzeit, #Mitglied_ID)


# Normalisierung von Datenbanken
## Aufgabe 1
a) 
Anomalien in der Tabelle "Kurse und Kundendaten"
1. Inkonsistente Datumsangaben:

    Beginndatum des Kurses "Zumba 1" für Doris Frisch liegt vor dem Laufzeitbeginn:
    Laufzeitbeginn: 12.12.2017
    Kursbeginn: 07.12.2017
    Enddatum des Kurses "Aerobic 2" für Maren Baumann liegt vor dem aktuellen Datum:
    Kursende: 27.11.2017
    Aktuelles Datum: 01.03.2024

2. Fehlerhafte Kostenangaben:

    Alle Kurse scheinen den gleichen Preis zu haben (50 Euro), unabhängig von Dauer oder Art des Kurses.
    Dies könnte auf einen Fehler in der Tabelle oder eine fehlende Differenzierung der Preise hindeuten.

3. Fehlende Informationen:

    Es gibt keine Spalte für die Kundennummer.
    Dies könnte die Zuordnung von Kundendaten zu Verträgen und Kursen erschweren.
    Es fehlen Informationen zu den Trainern:
    Es gibt nur die Namen der Trainer, aber keine weiteren Details wie Qualifikationen oder Kontaktdaten.

4. Unvollständige Datensätze:

    Der Datensatz für Anke Trost enthält keine Informationen zum Kurs.
    Es ist unklar, an welchem Kurs Anke Trost teilgenommen hat.

5. Redundante Informationen:

    Die IBAN und BIC der Kunden werden sowohl im ersten als auch im zweiten Datensatz für Maren Baumann wiederholt.
    Dies ist redundant und könnte zu Fehlern führen.

6. Ungewöhnliche Dateneinträge:

    Maren Baumann hat zwei Verträge mit derselben Laufzeit (2 Jahre).
    Dies könnte ein Fehler sein oder es könnte eine besondere Situation dahinterstecken, die in der Tabelle nicht erklärt wird.

b)

### 3. Normalform

Tabelle Kunden
<u>K-ID</u> | Kundenname | Adresse | PLZ | Ort | IBAN | BIC | Bank
--- | --- | --- | --- | --- | --- | --- | ---
1 | Doris Frisch | Esperantostr. 76 | 60329 | Frankfurt | DE12500105170648489890 | INGDDEFFXXX | Commerzbank
2 | Anke Trost | Am Hang 5 | 60329 | Frankfurt | DE12500105170648489890 | INGDDEFFXXX | Volksbank
3 | Maren Baumann | Am Hang 5 | 60329 | Frankfurt | DE12500105170648489890 | INGDDEFFXXX | Volksbank

Tabelle Kurse
<u>Kurs-ID</u> | Kursname | Trainer | Beginndatum | Enddatum | Kosten
--- | --- | --- | --- | --- | ---
1 | Zumba 1 | Franz Meier | 12.12.2017 | 12.12.2019 | 50
2 | Aerobic 2 | Franz Meier | 12.12.2017 | 12.12.2019 | 50
3 | Pilates 1 | Franz Meier | 12.12.2017 | 12.12.2019 | 50

Tabelle Verträge
<u>V-ID</u> | K-ID | Kurs-ID | Laufzeitbeginn | Laufzeitende
--- | --- | --- | --- | ---
1 | 1 | 1 | 12.12.2017 | 12.12.2019
2 | 2 | 2 | 12.12.2017 | 12.12.2019
3 | 3 | 3 | 12.12.2017 | 12.12.2019

### 4. Normalform

Tabelle Kunden
<u>K-ID</u> | Kundenname | Adresse | PLZ | Ort
--- | --- | --- | --- | ---
1 | Doris Frisch | Esperantostr. 76 | 60329 | Frankfurt
2 | Anke Trost | Am Hang 5 | 60329 | Frankfurt
3 | Maren Baumann | Am Hang 5 | 60329 | Frankfurt

Tabelle Bankverbindung
<u>K-ID</u> | IBAN | BIC | Bank
--- | --- | --- | ---
1 | DE12500105170648489890 | INGDDEFFXXX | Commerzbank
2 | DE12500105170648489890 | INGDDEFFXXX | Volksbank
3 | DE12500105170648489890 | INGDDEFFXXX | Volksbank

Tabelle Kurse
<u>Kurs-ID</u> | Kursname | Trainer | Beginndatum | Enddatum | Kosten
--- | --- | --- | --- | --- | ---
1 | Zumba 1 | Franz Meier | 12.12.2017 | 12.12.2019 | 50
2 | Aerobic 2 | Franz Meier | 12.12.2017 | 12.12.2019 | 50
3 | Pilates 1 | Franz Meier | 12.12.2017 | 12.12.2019 | 50

Tabelle Verträge
<u>V-ID</u> | K-ID | Kurs-ID | Laufzeitbeginn | Laufzeitende
--- | --- | --- | --- | ---
1 | 1 | 1 | 12.12.2017 | 12.12.2019
2 | 2 | 2 | 12.12.2017 | 12.12.2019
3 | 3 | 3 | 12.12.2017 | 12.12.2019

Tabelle Trainer
<u>Trainer-ID</u> | Trainername
--- | ---
1 | Franz Meier
2 | Edgar Franz

Tabelle Trainer-Kurse
<u>Trainer-ID</u> | <u>Kurs-ID</u>
--- | ---
1 | 1
1 | 2
1 | 3
2 | 1
2 | 2
2 | 3
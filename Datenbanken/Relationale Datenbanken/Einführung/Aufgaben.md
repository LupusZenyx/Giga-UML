# Aufgabe 1.1
## Datensatz:

- Eine Sammlung von Daten, die zusammengehören.
- In der Tabelle "Firmenwagen" gibt es vier Datensätze, die jeweils Informationen über einen einzelnen Firmenwagen enthalten.

## Tupel:

- Eine Zeile in einer Tabelle.
- Jedes der vier Zeilen in der Tabelle "Firmenwagen" stellt ein Tupel dar.

## Datenfeld:

- Eine Spalte in einer Tabelle.
- Die Tabelle "Firmenwagen" hat drei Datenfelder: "KFZ-Kennz.", "Typ" und "Baujahr".

## Attribut:

- Eine Eigenschaft, die in einem Datenfeld gespeichert wird.
- Die Attribute in der Tabelle "Firmenwagen" sind:
- - KFZ-Kennzeichen
- - Typ
- - Baujahr

## Attributwert:

- Der Wert eines Attributs für einen bestimmten Datensatz.
- Beispiele für Attributwerte in der Tabelle "Firmenwagen" sind:
- - KFZ-Kennzeichen: LM-AA 42
- - Typ: Mazda 6
- - Baujahr: 2023

# Aufgabe 1.2
- Der Primärschlüssel ist ein wichtiges Konzept in relationalen Datenbanken, das zur eindeutigen Identifizierung von Datensätzen, zur Verknüpfung von Tabellen und zur Gewährleistung der Datenintegrität verwendet wird.
- Identifizierung von Datensätzen: Der Primärschlüssel ermöglicht es, einzelne Datensätze in der Tabelle eindeutig zu identifizieren und darauf zuzugreifen.
- Verknüpfung von Tabellen: Primärschlüssel werden verwendet, um Beziehungen zwischen Tabellen in einer relationalen Datenbank herzustellen.
- Gewährleistung der Datenintegrität: Der Primärschlüssel hilft dabei, die Datenintegrität zu gewährleisten, indem er Duplikate und Datensätze mit fehlenden Werten verhindert.
- Beispiele für Primärschlüssel:
- - In einer Tabelle mit Kundendaten könnte der Primärschlüssel die Kundennummer sein.
- - In einer Tabelle mit Bestelldaten könnte der Primärschlüssel die Bestellnummer sein.
- - In einer Tabelle mit Produktinformationen könnte der Primärschlüssel die Produkt-ID sein.

# Aufgabe 1.3
## Primärschlüssel:
Arten:
- Natürlicher: Eindeutige Kennung in der realen Welt (z.B. VIN, Personalnummer).
- Zusammengesetzt: Kombination mehrerer Attribute (z.B. Vorname, Nachname, Geburtsdatum).
- Künstlich: Automatisch generierte ID (z.B. fortlaufende Nummer).

Auswahl:
- Eindeutigkeit: Jeder Datensatz muss eindeutig identifizierbar sein.
- Minimalität: So klein wie möglich (Anzahl der Attribute).
- Stabilität: Keine Änderung im Laufe der Zeit.
- Keine NULL-Werte: Keine leeren Felder.

Beispiele:
- Firmenwagen: Fahrgestellnummer
- Mitarbeiter: Personalnummer

Alternativen:
- Zwei Primärschlüssel bei Bedarf (z.B. eindeutige Identifizierung & Performance).

# Aufgabe 2
- INT: Zahlen
- DOUBLE: Dezimalzahlen
- VARCHAR(n): Variablen
- BOOLEAN: true/false
- TIMESTAMP: Zeiten
- DATE: Daten
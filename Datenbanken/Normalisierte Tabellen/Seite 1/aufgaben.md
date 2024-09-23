# Noramlisiertes Datenbankmodell
## Aufgabe 1

Fachlehrer
 Lehrerkürzel | Lehrername | Fachname | Fachleiterkürzel | Fachleitername
-------------|------------|----------|------------------|---------------
Hei | Heitech | Info | Hei | Lotech
Mid | Middletech | Info | Hei | Lotech
Zwi | Zwitech | Info | Hei | Lotech
Jag | Jagger | Musik | Jag | Brahms
Sch | Schiller | Deutsch | Sch | Ratlos
Goe | Goethe | Deutsch | Sch | Ratlos

1. Einfügeanomalie

Eine Einfügeanomalie tritt auf, wenn es nicht möglich ist, neue Daten in die Datenbank einzufügen, weil die Daten nicht in allen Spalten der Tabelle vorhanden sind.

Beispiel:

Es soll ein neuer Lehrer mit dem Namen "Wagner" und dem Fach "Mathematik" hinzugefügt werden.
Da es keinen Fachleiter für Mathematik gibt, kann der neue Lehrer nicht in die Tabelle eingefügt werden.

2. Änderungsanomalie

Eine Änderungsanomalie tritt auf, wenn eine Änderung eines Attributwerts in einer Spalte zu Inkonsistenzen in der Datenbank führt.

Beispiel:

Der Fachleiter für Deutsch wechselt von "Schiller" zu "Goethe".
Da "Schiller" in der Spalte "Fachleiter Kürzel" in mehreren Datensätzen vorkommt, müssen alle diese Datensätze manuell geändert werden.

3. Löschanomalie

Eine Löschanomalie tritt auf, wenn das Löschen eines Datensatzes zu einem Verlust von Informationen führt.

Beispiel:

Der Lehrer "Heitech" wird aus der Datenbank gelöscht.
Da "Heitech" auch Fachleiter für Informatik ist, gehen die Informationen über den Fachleiter für Informatik verloren.

## Aufgabe 2
1. Normalform (1NF):

    Eine Relation befindet sich in der 1NF, wenn alle ihre Attribute atomar sind und alle Daten in der Tabelle in einzelnen Feldern gespeichert sind. Ein Attribut ist atomar, wenn es nicht weiter in kleinere, bedeutungstragende Teile zerlegt werden kann. Es dürfen keine Mehrfachwerte in einem Attributfeld oder Doppelungen von Daten in derselben Tabelle gespeichert sein. Jede Zeile in der Tabelle und alle Datensätze müssen eindeutig identifizierbar sein, z.B. durch einen Primärschlüssel.

2. Normalform (2NF):

    Eine Relation befindet sich in der 2NF, wenn sie sich in der 1NF befindet und alle Daten in der Tabelle vom Primärschlüssel abhängen. Der Primärschlüssel ist die Spalte, die jede Zeile eindeutig identifiziert. Es dürfen keine indirekten Abhängigkeiten zwischen den Daten oder transitiven funktionalen Abhängigkeiten zwischen Nicht-Primärattributen existieren. Eine funktionale Abhängigkeit besagt, dass ein Attribut (A) von einem anderen Attribut (B) abhängt, wenn für jeden Wert von B es immer den gleichen Wert von A gibt. Eine transitive funktionale Abhängigkeit liegt vor, wenn A von B und B von C abhängt, aber A nicht direkt von C abhängt.

3. Normalform (3NF):

    Eine Relation befindet sich in der 3NF, wenn sie sich in der 2NF befindet und alle Daten in der Tabelle vollständig vom Primärschlüssel abhängen. Es darf keine teilweisen Abhängigkeiten von anderen Spalten oder transitiven funktionalen Abhängigkeiten zwischen Nicht-Primärattributen und Primärschlüsselkandidaten existieren. Anders ausgedrückt: Alle Nicht-Primäratribute in der 3NF sind vollständig vom Primärschlüsselkandidaten abhängig.

## Aufgabe 3

a) Warum befindet sich die Tabelle nicht in der 1. Normalform?

Die Tabelle befindet sich nicht in der 1. Normalform, da sie gegen zwei der wichtigsten Regeln der 1NF verstößt:

1. Regel: Atomarität:

- Das Attribut "Projekt" ist nicht atomar. Es enthält mehrere Informationen in einem Feld, nämlich die Projektnummer und den Projektnamen.
- Das Attribut "Mitarbeiter" ist ebenfalls nicht atomar. Es kann mehrere Mitarbeiternamen enthalten, die an einem Projekt arbeiten.
2. Regel: Eindeutigkeit:

- Die Kombination aus "MNr" und "Projekt" ist nicht eindeutig. Mehrere Datensätze können die gleiche Kombination haben, wenn ein Mitarbeiter an mehreren Projekten arbeitet.

b) Überführen Sie die Tabelle in die 1. Normalform.

Um die Tabelle in die 1. Normalform zu überführen, müssen wir die beiden oben genannten Probleme beheben:

1. Atomarität:

Das Attribut "Projekt" muss in zwei separate Attribute aufgeteilt werden: "Projektnummer" und "Projektname".
Das Attribut "Mitarbeiter" muss in eine separate Tabelle mit den Attributen "MNr", "Mitarbeitername" und anderen relevanten Informationen über die Mitarbeiter verschoben werden.
2. Eindeutigkeit:

Um die Eindeutigkeit zu gewährleisten, muss der Primärschlüssel der Tabelle neu definiert werden.

Tabelle "Projekte":
Projektnummer | Projektname
--------------|------------
1 | Projekt A
7 | Projekt B
11 | Projekt C


Tabelle "Mitarbeiter":

MNr | Mitarbeitername
----|---------------
200	| Huber
207	| Schmitz


Tabelle "Projektmitarbeiter":

MNr	| Projektnummer
----|--------------
200	| 1
200	| 7
207	| 11


## Aufgabe 4

a) Zeigen, dass die Tabelle nicht in der 2. Normalform, aber in der 1. Normalform ist
1. Normalform:

    Die Tabelle befindet sich in der 1. Normalform, da alle Attribute atomar sind, d.h. keine zusammengesetzten Werte enthalten.

2. Normalform:

    Die Tabelle befindet sich nicht in der 2. Normalform, da sie gegen die vollständige funktionale Abhängigkeit verstößt.

Primärschlüssel: Der Primärschlüssel der Tabelle ist die Kombination aus CD-ID und Track.
Attribut "Interpret": Das Attribut "Interpret" ist nicht vollständig funktional vom Primärschlüssel abhängig.

Begründung:
- Der Interpret ist nicht für jeden Track eindeutig.

Beispiel: In der Tabelle gibt es zwei Tracks von "Nightwish".

Anomalie:
Diese Situation führt zu einer anomalen Datenredundanz:
- Wenn sich der Name des Interpreten ändert, muss dieser in allen Tracks des Interpreten geändert werden.

b) Überführen Sie die Tabelle in die 2. Normalform.

Tabelle 1: Alben

Attribut | Datentyp | Primärschlüssel
--------|---------|----------------
CD-ID | Integer | Ja
Albumtitel | String | Ja
Interpret | String | Nein

Tabelle 2: Tracks

Attribut | Datentyp | Primärschlüssel | Fremdschlüssel
--------|---------|----------------|--------------
CD-ID | Integer | Nein | Ja (Tabelle 1: Alben)
Track | Integer | Ja | -
Titel | String | Nein | -

## Aufgabe 5
Die Tabelle befindet sich in der ersten Normalform (1NF).

Begründung:

- Alle Attribute in der Tabelle sind atomar, d.h. sie lassen sich nicht in weitere Attribute zerlegen.
- Es gibt keine Wiederholungsgruppen. In jeder Zeile der Tabelle sind eindeutige Informationen über einen Abteilungsmitarbeiter enthalten.

Die Tabelle befindet sich nicht in der dritten Normalform, da:

- In der dritten Normalform (3NF) darf kein Nichtschlüsselattribut von einem anderen Nichtschlüsselattribut abhängen. In dieser Tabelle ist das Attribut "Bezeichnung" jedoch vom Attribut "Abteilung" abhängig.
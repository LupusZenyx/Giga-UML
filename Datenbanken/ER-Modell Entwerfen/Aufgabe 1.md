# a) 
## ER-Modell:
- png


# b) 
- Der Primärschlüssel (PK) ist ein eindeutiges Attribut oder eine Gruppe von Attributen in einer Entitätstabelle, das jede Zeile in dieser Tabelle eindeutig identifiziert. Der Zweck besteht darin, Beziehungen zwischen Tabellen herzustellen und die Integrität der Datenbank zu gewährleisten. Für jeden Entitätstyp im ER-Modell wird ein Primärschlüssel festgelegt, um die Eindeutigkeit der Entitäten zu gewährleisten. Im obigen ER-Modell sind die Primärschlüssel jeweils mit (PK) markiert.

# c) 
## Kardinalitäten:

```
[Abteilung] - [Mitarbeiter]: 1:n (Ein Abteilung kann mehrere Mitarbeiter haben, aber ein Mitarbeiter gehört genau zu einer Abteilung)
[Mitarbeiter] - [Arbeitsvertrag]: 1:1 (Ein Mitarbeiter hat genau einen Arbeitsvertrag)
[Mitarbeiter] - [Projektzuordnung]: 1:n (Ein Mitarbeiter kann an mehreren Projekten teilnehmen)
[Projekt] - [Projektzuordnung]: 1:n (Ein Projekt hat mehrere Zuordnungen von Mitarbeitern)
```

# d) 
## Erläuterung der Datentypen:
- INT: Ganzzahliger Datentyp für ganze Zahlen.
- DOUBLE: Datentyp für Gleitkommazahlen (mit Dezimalstellen).
- VARCHAR(30): Zeichenketten-Datentyp mit variabler Länge (bis zu 30 Zeichen).
- BOOLEAN: Datentyp für Wahrheitswerte (true/false).
- DATE: Datentyp für Datumsangaben im Format YYYY-MM-DD.
- TIMESTAMP: Datentyp für Datums- und Zeitangaben im Format YYYY-MM-DD HH:MM:SS.

# e) 
## Tabelle der Attribute des Entitätstyps "Arbeitsvertrag" mit passenden Datentypen:

```
[Arbeitsvertrag]
- ArbeitsvertragID: INT
- Funktion: VARCHAR(30)
- Gehalt: DOUBLE
- Unterzeichnungsdatum: DATE
- MitarbeiterID: INT (FK)
```

-----

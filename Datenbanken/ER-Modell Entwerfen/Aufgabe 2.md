# Aufgabe 1: Entity-Relationship-Modell für einen Autoreifenhändler
## Entitätstypen:

- Reifen
- Großhändler
- Kunde
- Rechnung

## Beziehungen:

- Reifen gehört zu Großhändler (1:n)
- Reifen wird verkauft an Kunde (1:n)
- Kunde hat Rechnung (1:n)
- Rechnung enthält Reifen (n:m)

## Kardinalitäten:

- Reifen: (1,n)
- Großhändler: (1,n)
- Kunde: (1,n)
- Rechnung: (1,n)

## Primärschlüssel:

- Reifen: (Reifenbezeichnung, Herstellername)
- Großhändler: (Großhändlername)
- Kunde: (Kundenname, Kundennummer)
- Rechnung: (Rechnungsnummer)

# Aufgabe 2: Entity-Relationship-Modell für Mitarbeiter in einer Firma
## Entitätstypen:

### Mitarbeiter
Beziehungen:
- Mitarbeiter hat Vorgesetzter (0:1, 1:1)
Kardinalitäten:
- Mitarbeiter: (1,n)
Primärschlüssel:

- Mitarbeiter: (Mitarbeitername, Personalnummer)

# Aufgabe 3: Entity-Relationship-Modell für eine Schule
## Entitätstypen:

- Schüler
- Klasse
- Arbeitsgemeinschaft
- Raum
- Lehrer

## Beziehungen:

- Schüler gehört zu Klasse (1:n)
- Schüler nimmt teil an Arbeitsgemeinschaft (n:m)
- Klasse hat Raum (1:n)
- Lehrer unterrichtet in Klasse (n:m)
- Lehrer leitet Arbeitsgemeinschaft (1:n)

## Kardinalitäten:

- Schüler: (1,n)
- Klasse: (1,n)
- Arbeitsgemeinschaft: (1,n)
- Raum: (1,n)
- Lehrer: (1,n)

## Primärschlüssel:

- Schüler: (Schülername, Schülernummer)
- Klasse: (Klassenname)
- Arbeitsgemeinschaft: (Arbeitsgemeinschaftsname)
- Raum: (Raumbezeichnung)
- Lehrer: (Lehrername, Personalnummer)

## Zusätzliche Hinweise:

Die Beziehung zwischen Schüler und Arbeitsgemeinschaft ist optional, da nicht alle Schüler an Arbeitsgemeinschaften teilnehmen müssen.
Die Beziehung zwischen Lehrer und Arbeitsgemeinschaft ist ebenfalls optional, da nicht alle Lehrer Arbeitsgemeinschaften leiten müssen.
Die Beziehung zwischen Lehrer und Klasse ist 1:n, da ein Lehrer in mehreren Klassen unterrichten kann.
Die Beziehung zwischen Lehrer und Klasse ist jedoch auch n:m, da eine Klasse von mehreren Lehrern unterrichtet werden kann.

## Diagramm:

yes

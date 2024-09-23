# Aufgaben zu SQL
## Aufgabe 1
### a) Anweisung:
```sql
SELECT MIN(Höhe)
FROM Berg
WHERE Gebirge = 'Himalaya';
```
### b) Anweisung:
```sql
SELECT AVG(Höhe)
FROM Berg
WHERE Gebirge = 'Himalaya';
```
### c) Anweisung:
```sql
SELECT SUM(Höhe)
FROM Berg
WHERE Gebirge = 'Himalaya';
```
## Aufgabe 2
### a) Anweisung:
```sql
SELECT COUNT(*) FROM BERG;
```
Diese Anweisung zählt die Gesamtanzahl der Zeilen in der Tabelle "BERG". Es werden alle Zeilen unabhängig vom Wert der Spalten gezählt. Das Ergebnis ist die Gesamtanzahl der Berge in der Tabelle.

### b) Anweisung:
```sql
SELECT COUNT(JAHR) FROM BERG;
```
Hier wird die Anzahl der nicht-NULL-Werte in der Spalte "JAHR" gezählt. Diese Anweisung zählt also die Anzahl der Berge, für die das Jahr bekannt ist. Wenn also ein Berg in der Tabelle ein Jahr hat, wird er gezählt.

### c) Anweisung:
```sql
SELECT (COUNT(*) - COUNT(JAHR)) FROM BERG;
```
Diese Anweisung zieht die Anzahl der Zeilen insgesamt von der Anzahl der Zeilen ab, in denen das Jahr bekannt ist. Das Ergebnis ist die Anzahl der Zeilen, in denen die "JAHR"-Spalte NULL ist. Mit anderen Worten, es zählt die Anzahl der Berge, für die das Jahr nicht bekannt ist.

### d) Anweisung:
```sql
SELECT COUNT(*) FROM BERG WHERE JAHR IS NULL;
```
Diese Anweisung zählt explizit die Anzahl der Zeilen, in denen die "JAHR"-Spalte NULL ist. Das Ergebnis ist die Anzahl der Berge, für die das Jahr nicht bekannt ist.

### e) Anweisung:
```sql
SELECT COUNT(*) FROM BERG WHERE JAHR IS NOT NULL;
```
Hier wird die Anzahl der Zeilen gezählt, in denen die "JAHR"-Spalte nicht NULL ist. Das Ergebnis ist die Anzahl der Berge, für die das Jahr bekannt ist.

## Unterschied zwischen dem "Wert" NULL und dem Wert 0:
- Der Wert NULL in einer Datenbank stellt die Abwesenheit eines Wertes oder einen unbekannten Wert dar. Es bedeutet, dass der Wert für die Spalte nicht vorhanden oder nicht bekannt ist.
- Der Wert 0 ist eine tatsächliche numerische Wert, der null repräsentiert, also das Fehlen von etwas. Im Gegensatz zu NULL ist 0 ein definierter Wert, der die Anzahl, Menge oder Wertigkeit von etwas ausdrückt.


## Extra
```sql
SELECT B_NAME
FROM BERG
WHERE HOEHE = (SELECT MIN(HOEHE) FROM BERG WHERE GEBIRGE = 'Himalaya');
```


```sql
SELECT COUNT(*)
FROM BERG
WHERE HOEHE > (SELECT AVG(HOEHE) FROM BERG WHERE GEBIRGE = 'Himalaya');
```

```sql
SELECT GEBIRGE, B_NAME, MAX(HOEHE) FROM BERG GROUP BY GEBIRGE;
```

```sql
SELECT GEBIRGE, MAX(HOEHE)
FROM BERG
GROUP BY GEBIRGE
HAVING MAX(HOEHE) >= 6000;
```
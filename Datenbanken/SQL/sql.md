# SQL
## a) SHOW TABLES:

x### Anweisung:
    SHOW TABLES;   

### Erklärung:
Diese Anweisung zeigt alle Tabellen an, die in der aktuell ausgewählten Datenbank vorhanden sind. Das Ergebnis ist eine Liste mit den Namen der Tabellen.


## b) SELECT * FROM BERG:

### Anweisung:
    SELECT * FROM BERG;   

### Erklärung:
Diese Anweisung wählt alle Datensätze aus der Tabelle "BERG" aus. Das Ergebnis ist eine Tabelle mit allen Spalten und Datensätzen der Tabelle "BERG".


## c) DESCRIBE BERG:

### Anweisung:
    DESCRIBE BERG;   

### Erklärung:
Diese Anweisung zeigt die Struktur der Tabelle "BERG" an. Das Ergebnis ist eine Tabelle mit Informationen über die einzelnen Spalten der Tabelle, z. B. den Spaltennamen, den Datentyp und die Länge.


## d) Sortieren nach Höhe (aufsteigend):

### Anweisung:
    SELECT * FROM BERG ORDER BY HOEHE ASC;   


## e) Sortieren nach Höhe (absteigend):

### Anweisung:
    SELECT * FROM BERG ORDER BY HOEHE DESC;   


## f) Namen und Höhen sortiert nach Höhe (aufsteigend):

### Anweisung:
    SELECT Bergname, HOEHE FROM BERG ORDER BY HOEHE ASC;   


## g) Anzahl der Datensätze:

## Anweisung:
    SELECT COUNT(*) FROM BERG;   


## h) Berge über 8000 Meter:

### Anweisung:
    SELECT * FROM BERG WHERE HOEHE >= 8000;   


## i) Berge im Himalaya:

### Anweisung:
    SELECT * FROM BERG WHERE Gebirge = 'Himalaya';   


## j) Anzahl der Berge über 8000 Meter:

### Anweisung:
    SELECT COUNT(*) FROM BERG WHERE HOEHE >= 8000;   


## k) Berge im Sagrosgebirge über 3000 Meter (absteigend sortiert):

### Anweisung:
    SELECT * FROM BERG WHERE Gebirge = 'Sagrosgebirge' AND HOEHE >= 3000 ORDER BY HOEHE DESC;   


### l) Berge mit Anfangsbuchstabe "F":

### Anweisung:
    SELECT * FROM BERG WHERE Bergname LIKE 'F%';   


## m) Anzahl der Berge mit Anfangsbuchstabe "F":

### Anweisung:
    SELECT COUNT(*) FROM BERGx WHERE Bergname LIKE 'F%';   

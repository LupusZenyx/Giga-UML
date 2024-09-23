# Normalisierung von Datenbanken
## Aufgabe 1
b) 

### 2. Normalform

Tabelle 1: Kunden

<u>Kunden-ID</u> | KundenName | Berater-ID#
--------------|------------|-----------
1 | Kai Mauer | 1
2 | Karl S. Ruhe | 2
3 | Hans A. Rostock | 1
4 | Roman Tisch | 1
5 | Timo Beil | 3

Tabelle 2: Berater

<u>Berater-ID</u> | BeraterName | Aufgabe | Stundenlohn
--------------|-------------|---------|------------
1 | Claus Thaler | IT-Berater | 50,00
2 | Bud Weiser | Finanzberater | 45,00
3 | Paul Aner | IT-Berater | 60,00
4 | Hein Ecken | Finanzberater | 30,00


### 3. Normalform

Tabelle 1: Kunden
<u>Kunden-ID</u> | KundenName | Berater-ID#
--------------|------------|-----------
1 | Kai Mauer | 1
2 | Karl S. Ruhe | 2
3 | Hans A. Rostock | 1
4 | Roman Tisch | 1
5 | Timo Beil | 3

Tabelle 2: Berater
<u>Berater-ID</u> | BeraterName | Aufgabe | Stundenlohn
--------------|-------------|---------|------------
1 | Claus Thaler | IT-Berater | 50,00
2 | Bud Weiser | Finanzberater | 45,00
3 | Paul Aner | IT-Berater | 60,00
4 | Hein Ecken | Finanzberater | 30,00

Tabelle 3: Kunden-Berater-Zuordnung
<u>Kunden-ID</u> | <u>Berater-ID</u>
--------------|--------------
1 | 1
2 | 2
3 | 1
4 | 1
5 | 3

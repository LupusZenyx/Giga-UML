# Seite 5
### Aufgabe 1

Die folgenden Aufgaben beziehen sich auf die abgebildete Tabelle klasse0815. In dieser Tabelle werden die Daten von Schülern der ``Klasse 0815`` gespeichert. Die jeweiligen SQL – Anweisungen sind zu notieren.

| ID | name   | vorname | note1 | note2 | note3 |
| --- | --- | --- | --- | --- | --- |
| 1     | Adler  | Horst          | 2      | 1  | NULL |
| 2     | Birne  | Helene      | NULL   | NULL  | NULL |
| 3     | Voll   | Horst          | 6      | 3  | NULL |
| 4     | Blöd  | Hein           | 5      | 3  | NULL |

### 1. Erstellen Sie die oben beschriebene Tabelle.
```SQL
CREATE TABLE klasse0815 (ID INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), vorname VARCHAR(20), note1 INT, note2 INT, note3 INT);
```
---
### 2. Löschen Sie das Attribut ``note3``.
```SQL
DELETE note3 FROM klasse0815;
```
---
### 3. Löschen Sie alle Attributwerte in der Spalte ``note2`` mit einer einzigen Anweisung.
- Ergebnis:

  | ID | name   | vorname | notel | note2 | +     |
  |---|---|---|---|---|---|
  | 1   | Adler  | Horst        | 2  | NULL  |       |
  | 2   | Birne  | Helene    | NULL  | NULL  |       |
  | 3   | Voll   | Horst        | 6  | NULL  |       |
  | 4   | Blöd  | Hein         | 5  | NULL  |       |

```SQL
UPDATE klasse0815 SET note2 = NULL;
```
---
### 4. Prüfen Sie, ob mit der folgenden Anweisung der korrekte Notenschnitt (trotz fehlender Noten) berechnet wird: ``SELECT AVG(note1) FROM klasse0815;``
- Es wird der korrekte Notenschnitt berechnet, da die fehlenden Noten als NULL interpretiert werden.
---
### 5. Ermitteln Sie die Anzahl der Schüler, welche eine Note erhalten haben.
```SQL
SELECT COUNT(*) FROM klasse0815 WHERE note1 IS NOT NULL; 
```
---
### 6. Ermitteln Sie die Anzahl der Schüler, welche keine Note erhalten haben.
```SQL
SELECT COUNT(*) FROM klasse0815 WHERE note1 IS NULL;
```
---
### 7. Die beste Note soll angezeigt werden.
```SQL
SELECT MAX(note1) FROM klasse0815;
```
---
### 8. Die Namen und Vornamen derjenigen Schüler, welche die beste Note erhalten haben, sollen angezeigt werden.
```SQL
SELECT name, vorname FROM klasse0815 WHERE note1 = (SELECT MAX(note1) FROM klasse0815);
```
---
### 9. Wieviel verschiedene Vornamen existieren in der Klasse 0815? (Die Anzahl soll ausgegeben werden.)
```SQL
SELECT COUNT(DISTINCT vorname) FROM klasse0815;
```
---
### 10. Fügen Sie einen neuen Datensatz ein. Der Name des Schülers soll dabei mehr Zeichen enthalten, als zulässig sind. Welche Meldung liefert das DBMS? Was wurde gespeichert?
```SQL
INSERT INTO klasse0815 (name, vorname, note1) VALUES ("Kastl", "Ruth", 4);
```
- Das DBMS liefert die Meldung: ``Data too long for column 'name' at row 1``.

---
### 11.  Erhöhen Sie die Anzahl der möglichen Zeichen für die Namen (nur Nachnamen) der Schüler.
```SQL
ALTER TABLE klasse0815 MODIFY name VARCHAR(30);
```

---
### 12. Zur Speicherung des Geburtsdatums soll die Tabelle ein neues Attribut (Name: ``geboren``) erhalten, welches den Datentyp ``DATE`` besitzt. Zum Testen ist für einen Schüler das Geburtsdatum einzugeben.
```SQL
ALTER TABLE klasse0815 ADD geboren DATE;
UPDATE klasse0815 SET geboren = "2000-01-01" WHERE name = "Kastl";
```

---
### 13. Der Tabelle ist ein weiteres Attribut (Name: geaendert) hinzuzufügen. Dort soll das DBMS automatisch für jeden Datensatz Datum und Uhrzeit der letzten Änderung speichern. Prüfen Sie anschließend, ob die Attributwerte vom DBMS korrekt eingetragen werden.
```SQL
ALTER TABLE klasse0815 ADD geaendert TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
```
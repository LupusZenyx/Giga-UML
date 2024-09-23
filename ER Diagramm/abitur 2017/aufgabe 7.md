## Aufgaben zu Datenbanken und SQL

**1. Beziehungstyp und ER-Diagramm**

Die Beziehung zwischen den Tabellen `kunden` und `berater` ist eine **1:n-Beziehung**. Ein Kunde kann von einem Berater betreut werden (1), aber ein Berater kann mehrere Kunden betreuen (n).

Das zugehörige ER-Diagramm sieht folgendermaßen aus:

```
Kunde ----(betreut von)--- Berater

|           |           |
| k_ID      | b_ID       |
| k_name     | b_name     |
| k_vorname  | b_vorname  |
| b_stundensatz |           |
```

**Primärschlüssel:**

* In der Tabelle `kunden`: `k_ID`
* In der Tabelle `berater`: `b_ID`

**2. Referentielle Integrität**

**Referentielle Integrität** bedeutet, dass ein Wert in einem Feld einer Tabelle auf einen vorhandenen Wert in einem Feld einer anderen Tabelle verweisen muss.

**Verletzung der referenziellen Integrität:**

* **Vorgang A:** Wenn der Datensatz des Kundenberaters Ingo Fuchs gelöscht wird, verletzen die Datensätze der Kunden, die von ihm betreut werden (z. B. Markus Huber), die referenzielle Integrität, da der Wert in der Spalte `b_ID` (7) nicht mehr auf einen vorhandenen Datensatz in der Tabelle `berater` verweist.
* **Vorgang B:** Wenn im Datensatz des Kunden Markus Huber in der Spalte `b_ID` der Wert 7 eingetragen wird, verstößt dies gegen die referenzielle Integrität, da es keinen Berater mit der ID 7 gibt.

**3. Datenbank anlegen und Tabellen erstellen**

Die folgende SQL-Anweisung legt eine Datenbank mit dem Namen `kundenverwaltung` an:

```sql
CREATE DATABASE kundenverwaltung;
```

Die folgenden SQL-Anweisungen erstellen die Tabellen `berater` und `kunden`:

```sql
-- Tabelle "berater"

CREATE TABLE berater (
  b_ID INT NOT NULL AUTO_INCREMENT,
  b_name VARCHAR(20),
  b_vorname VARCHAR(20),
  b_stundensatz DOUBLE(8,2),
  PRIMARY KEY (b_ID)
) ENGINE=InnoDB;

-- Tabelle "kunden"

CREATE TABLE kunden (
  k_ID INT NOT NULL AUTO_INCREMENT,
  k_name VARCHAR(20),
  k_vorname VARCHAR(20),
  b_ID INT,
  PRIMARY KEY (k_ID),
  FOREIGN KEY (b_ID) REFERENCES berater (b_ID) ON DELETE NO ACTION
) ENGINE=InnoDB;
```

**Erklärung der Anweisungen:**

* `CREATE TABLE`: Legt eine neue Tabelle an.
* `INT`: Datentyp für Ganzzahlen
* `VARCHAR(20)`: Datentyp für Text mit maximal 20 Zeichen
* `DOUBLE(8,2)`: Datentyp für Gleitkommazahlen mit 8 Stellen insgesamt und 2 Nachkommastellen
* `NOT NULL`: Spalte darf keinen NULL-Wert enthalten
* `AUTO_INCREMENT`: Wert der Spalte wird automatisch bei Einfügen eines neuen Datensatzes erhöht
* `PRIMARY KEY`: Primärschlüssel der Tabelle
* `FOREIGN KEY`: Verweist auf ein Feld in einer anderen Tabelle
* `REFERENCES`: Name der Tabelle und des Feldes, auf das verwiesen wird
* `ON DELETE NO ACTION`: Wenn der Datensatz in der referenzierten Tabelle gelöscht wird, wird der Datensatz in der referenzierenden Tabelle nicht gelöscht

**Reihenfolge der Anweisungen:**

Die Tabelle `berater` muss zuerst erstellt werden, da die Tabelle `kunden` einen Fremdschlüssel auf die Tabelle `berater` referenziert.

**4. Auswirkungen von ON DELETE Optionen**

Die folgenden Optionen sind für `ON DELETE` verfügbar:

* **NO ACTION:** Der Löschvorgang wird abgebrochen, wenn die referenzielle Integrität verletzt wird.
* **SET NULL:** Der Wert in der Spalte `b_ID` der Tabelle `kunden` wird auf NULL gesetzt, wenn der Datensatz des Beraters gelöscht wird.
* **CASCADE:** Der Datensatz in der Tabelle `kunden` wird ebenfalls gelöscht, wenn der Datensatz des Beraters gelöscht wird.

**Fazit:**

Die Aufgaben zu Datenbanken und SQL wurden erfolgreich gelöst.
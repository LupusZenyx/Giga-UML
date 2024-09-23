# Ergänzung zum ER-Diagramm
### 1. Aufgabe

**a) Zusammengesetzte Attribute:** 
Zusammengesetzte Attribute bestehen aus mehreren einfachen Attributen. Zum Beispiel kann die Adresse eines Kunden aus Straße, Stadt und Postleitzahl bestehen.

**b) Mehrwertige Attribute:** 
Mehrwertige Attribute können mehrere Werte für dasselbe Attribut haben. Zum Beispiel kann ein Student mehrere Telefonnummern haben.

**c) Abgeleitete Attribute:** 
Abgeleitete Attribute werden aus anderen Attributen berechnet und können in einer Relation gespeichert werden. Zum Beispiel kann das Alter eines Kunden aus seinem Geburtsdatum berechnet werden.

Für die Transformation in das Relationenmodell müssen folgende Punkte beachtet werden:

- **Zusammengesetzte Attribute:** Jedes einfache Attribut wird zu einem eigenen Attribut in der entsprechenden Relation.
- **Mehrwertige Attribute:** Sie werden in eine separate Relation ausgelagert, mit einer Fremdschlüsselverbindung zur Hauptrelation.
- **Abgeleitete Attribute:** Diese werden nicht direkt in die Datenbank aufgenommen, sondern bei Bedarf berechnet, um Inkonsistenzen zu vermeiden.

Vorteile:
- Die Datenbank bleibt normalisiert und besser strukturiert.
- Es ermöglicht eine effiziente Datenverwaltung.

Nachteile:
- Es kann zu erhöhtem Speicherbedarf führen.
- Die Abfragekomplexität kann steigen.

### 2. Aufgabe

**Schwache Entitäten:**
Schwache Entitäten sind Entitäten, die von einer anderen Entität abhängig sind und kein eigenes Identifizierungsattribut besitzen. Sie können nur durch ihre Beziehung zu anderen Entitäten identifiziert werden.

Bei der Transformation in das Relationenmodell müssen folgende Punkte beachtet werden:

- Schwache Entitäten werden als separate Relationen erstellt.
- Ihre Schlüssel bestehen aus dem Schlüssel der übergeordneten Entität und einem eigenen Identifizierer.

### 3. Aufgabe

**Vererbung/Generalisierung im ER-Modell:**
Vererbung oder Generalisierung wird im ER-Modell durch die Verwendung von Super- und Subtypen dargestellt. Superentitäten sind allgemeine Entitäten, von denen Subentitäten spezialisiert werden.

Bei der Umsetzung in das Relationenmodell gibt es verschiedene Varianten:

- **Einzelne Tabelle pro Klasse:** Jede Entitätsklasse (Super- oder Subtyp) wird in einer eigenen Tabelle abgebildet.
- **Gemeinsame Tabelle für alle Klassen:** Eine Tabelle wird erstellt, die Attribute aller Klassen enthält, wobei für nicht zutreffende Attribute NULL-Werte verwendet werden.

Vorteile:
- Einzelne Tabelle pro Klasse: Bessere Strukturierung, unterstützt spezifische Abfragen.
- Gemeinsame Tabelle: Einfacheres Schema, weniger Joins.

Nachteile:
- Einzelne Tabelle pro Klasse: Kann zu Redundanzen führen, komplexe Joins.
- Gemeinsame Tabelle: Kann NULL-Werte enthalten, schwer lesbar.

### 4. Aufgabe

**Ternäre Beziehungen:**
Ternäre Beziehungen sind Beziehungen zwischen drei Entitäten. Sie werden im ER-Modell durch eine Diamantform dargestellt, wobei die Beziehung zwischen den drei Entitäten in der Mitte steht.

Bei der Transformation in das Relationenmodell müssen die drei Entitäten in separate Relationen umgewandelt werden, und die Beziehung wird durch Fremdschlüsselverbindungen zwischen den Relationen dargestellt.
**1. Aufgabe**

**Vorteile von verketteten Listen:**

* **Flexibilität:** Verkettete Listen können beliebig erweitert oder verkürzt werden, ohne dass die Liste neu initialisiert werden muss.
* **Effizienz:** Verkettete Listen können effizienter Elemente an beliebiger Stelle einfügen oder löschen als starre Listen.

**Nachteile von verketteten Listen:**

* **Speicherbedarf:** Verkettete Listen benötigen mehr Speicherplatz als starre Listen, da für jedes Element zusätzlich ein Zeiger auf das nächste Element benötigt wird.
* **Implementierung:** Die Implementierung von verketteten Listen ist etwas komplexer als die von starren Listen.

**2. Aufgabe**

Der Unterschied zwischen einfach und doppelt verketteten Listen besteht darin, dass bei einfach verketteten Listen jedes Element nur einen Zeiger auf das nächste Element enthält, während bei doppelt verketteten Listen jedes Element zusätzlich einen Zeiger auf das vorherige Element enthält.

**3. Aufgabe**

**Queue**

* **enqueue(element)**: Fügt ein Element am Ende der Liste ein.
* **dequeue():** Entfernt das erste Element aus der Liste.
* **isEmpty():** Liefert true zurück, wenn die Liste leer ist.
* **size():** Liefert die Anzahl der Elemente in der Liste zurück.

**Stack**

* **push(element)**: Fügt ein Element am Anfang der Liste ein.
* **pop():** Entfernt das erste Element aus der Liste.
* **isEmpty():** Liefert true zurück, wenn die Liste leer ist.
* **size():** Liefert die Anzahl der Elemente in der Liste zurück.

**4. Aufgabe**

Das Klassendiagramm für die einfach verkettete Liste als Queue ist wie folgt:

```
class Bestellung {

  int id;
  String kunde;
  String artikel;
  int menge;

  Bestellung(int id, String kunde, String artikel, int menge) {
    this.id = id;
    this.kunde = kunde;
    this.artikel = artikel;
    this.menge = menge;
  }

}

class BestellungsListe {

  private Bestellung erstesElement;
  private Bestellung letztesElement;

  public BestellungsListe() {
    this.erstesElement = null;
    this.letztesElement = null;
  }

  public void enqueue(Bestellung bestellung) {
    if (erstesElement == null) {
      erstesElement = bestellung;
      letztesElement = bestellung;
    } else {
      letztesElement.naechstesElement = bestellung;
      letztesElement = bestellung;
    }
  }

  public Bestellung dequeue() {
    if (erstesElement == null) {
      return null;
    }

    Bestellung bestellung = erstesElement;
    erstesElement = erstesElement.naechstesElement;

    if (erstesElement == null) {
      letztesElement = null;
    }

    return bestellung;
  }

  public boolean isEmpty() {
    return erstesElement == null;
  }

  public int size() {
    int anzahlElemente = 0;

    Bestellung aktuellesElement = erstesElement;
    while (aktuellesElement != null) {
      anzahlElemente++;
      aktuellesElement = aktuellesElement.naechstesElement;
    }

    return anzahlElemente;
  }

}
```

Der Javacode für die Implementierung der Queue-Methoden ist wie folgt:

```
public void enqueue(Bestellung bestellung) {
  if (erstesElement == null) {
    erstesElement = bestellung;
    letztesElement = bestellung;
  } else {
    letztesElement.naechstesElement = bestellung;
    letztesElement = bestellung;
  }
}

public Bestellung dequeue() {
  if (erstesElement == null) {
    return null;
  }

  Bestellung bestellung = erstesElement;
  erstesElement = erstesElement.naechstesElement;

  if (erstesElement == null) {
    letztesElement = null;
  }

  return bestellung;
}

public boolean isEmpty() {
  return erstesElement == null;
}


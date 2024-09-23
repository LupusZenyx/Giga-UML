
# Aufgabe 1: Vergleich von starren Listen und verketteten Listen

## Vorteile von verketteten Listen:

- Flexibilität: Verkettete Listen können beliebig erweitert oder gekürzt werden, ohne dass die gesamte Liste kopiert werden muss.
- Effizienz: Verkettete Listen können effizienter als starre Listen implementiert werden, wenn häufig Elemente an den Anfang oder das Ende der Liste hinzugefügt oder entfernt werden müssen.

## Nachteile von verketteten Listen:

- Platzbedarf: Verkettete Listen benötigen mehr Speicherplatz als starre Listen, da für jedes Element der Liste zusätzlich ein Zeiger auf das nächste Element benötigt wird.
- Komplexität: Die Implementierung von verketteten Listen ist komplexer als die Implementierung von starren Listen.


# Aufgabe 2: Unterschied zwischen einfach und doppelt verketteten Listen

- Der einzige Unterschied zwischen einfach und doppelt verketteten Listen besteht darin, dass einfach verkettete Listen nur einen Zeiger auf das nächste Element enthalten, während doppelt verkettete Listen zusätzlich einen Zeiger auf das vorherige Element enthalten. Dieser Unterschied ermöglicht es, in doppelt verketteten Listen Elemente in beide Richtungen durchlaufen zu können.

# Aufgabe 3: Methoden für Queue- und Stack-Listen

## Queue-Listen

- enqueue(Element e): Fügt das Element e an das Ende der Liste an.
- dequeue(): Entfernt das Element am Anfang der Liste und gibt es zurück.
- peek(): Gibt das Element am Anfang der Liste zurück, ohne es zu entfernen.
- size(): Gibt die Anzahl der Elemente in der Liste zurück.

## Stack-Listen

- push(Element e): Fügt das Element e an den Anfang der Liste an.
- pop(): Entfernt das Element am Anfang der Liste und gibt es zurück.
- top(): Gibt das Element am Anfang der Liste zurück, ohne es zu entfernen.
- size(): Gibt die Anzahl der Elemente in der Liste zurück.
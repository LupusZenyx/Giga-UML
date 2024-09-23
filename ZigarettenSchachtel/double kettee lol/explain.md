# Doppelt verkettete Listen
## Der wesentliche Unterschied zwischen einfach und doppelt verketteten Listen besteht darin, dass jedes Listenelement in einer doppelt verketteten Liste zusätzlich zum Verweis auf den Nachfolger auch einen Verweis auf den Vorgänger enthält.

- In einer einfach verketteten Liste enthält jedes Listenelement nur einen Verweis auf den Nachfolger in der Liste. Dadurch ist es möglich, nur in eine Richtung durch die Liste zu iterieren, nämlich von vorne nach hinten. Das Einfügen und Entfernen von Listenelementen in der Mitte der Liste ist daher relativ aufwendig, da sich der Einfüge- oder Löschpunkt zunächst entlang der Nachfolger-Verweise finden muss.

- In einer doppelt verketteten Liste enthält jedes Listenelement zusätzlich zum Verweis auf den Nachfolger auch einen Verweis auf den Vorgänger. Dadurch ist es möglich, in beide Richtungen durch die Liste zu iterieren, also von vorne nach hinten und von hinten nach vorne. Das Einfügen und Entfernen von Listenelementen in der Mitte der Liste ist daher relativ einfach, da sich der Einfüge- oder Löschpunkt direkt über den Vorgänger-Verweis erreichen lässt.

## Zusammenfassend lässt sich sagen, dass doppelt verkettete Listen gegenüber einfach verketteten Listen folgende Vorteile bieten:

- Einfacheres Einfügen und Entfernen von Listenelementen in der Mitte der Liste
- Mögliche Iterierung in beide Richtungen
- Im Gegenzug sind doppelt verkettete Listen etwas ineffizienter als einfach verkettete Listen, da jedes Listenelement einen zusätzlichen Verweis enthält.
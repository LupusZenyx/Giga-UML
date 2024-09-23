import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node<T> oldTop = top;
        top = top.next;
        return oldTop.element;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}

// Der Vorschlag des Projektmanagers, einen Stapel zu verwenden, ist sinnvoll, da Stapel gut für Vorgänge geeignet sind, die in umgekehrter Reihenfolge ausgeführt werden müssen. In diesem Fall muss das Programm in der Lage sein, Elemente in umgekehrter Reihenfolge hinzuzufügen und zu entfernen, was genau die Aufgabe eines Stapels ist. Eine Array-Datenstruktur ist für diese Aufgabe nicht geeignet, da Arrays beim Hinzufügen und Entfernen von Elementen am Anfang oder Ende der Datenstruktur nicht so effizient sind wie Stapel. Eine Warteschlange ist für diese Aufgabe ebenfalls nicht geeignet, da Warteschlangen als FIFO-Datenstrukturen (First In First Out) konzipiert sind. In diesem Fall muss das Programm in der Lage sein, Elemente in der LIFO-Reihenfolge (Last In First Out) hinzuzufügen und zu entfernen.
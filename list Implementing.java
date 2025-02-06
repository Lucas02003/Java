public class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E e) {
        element = e;
        next = null; // Initialize next to null
        previous = null; // Initialize previous to null
    }
}
TwoWayLinkedList Class Implementation
language-java
 Copy code
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public TwoWayLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Implementing methods from MyList interface
    // Add methods like add, remove, get, etc.

    @Override
    public ListIterator<E> listIterator() {
        return new TwoWayListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> current;
        private int index;

        public TwoWayListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            this.index = index;
            current = (index == size) ? null : getNodeAt(index);
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            index++;
            return element;
        }

        // Implement other ListIterator methods...
    }

    private Node<E> getNodeAt(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
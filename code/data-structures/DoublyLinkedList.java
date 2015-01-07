public class DoublyLinkedList<E> {

    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E data, Node<E> next, Node<E> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node<E> first;
    private Node<E> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void addFront(E item) {
        first = new Node<E>(item, first, null);
        Node<E> second = first.next;
        if (second != null) {
            // There was already at leat one node
            second.previous = first;
        } else {
            // This is the first addition, last and first are same
            last = first;
        }
    }

    public E removeFront() {
        if (null == first) {
            throw new RuntimeException("Can't removeFront() on empty list.");
        }
        E answer = first.data;
        first = first.next;
        first.previous = null;
        return answer;
    }

    public E removeBack() {
        if (null == last) {
            throw new RuntimeException("Can't removeBack() on empty list.");
        }
        E answer = last.data;
        last = last.previous;
        last.next = null;
        return answer;
    }

    public void remove(int i) {
        if (first == null) {
            return;
        }
        if (i == 0) {
            first = first.next;
            first.previous = null;
        } else {
            Node<E> node = first;
            while (i > 0 && node.next != null) {
                node = node.next;
                i--;
            }
            if (i == 0) {
                if (last == node) {
                    last = node.previous;
                    last.next = null;
                } else {
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                }
           }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node node = first; node != null; node = node.next) {
            sb.append(node.data + " ");

        }
        return sb.toString() + "]";
    }

    public String toReverseString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node node = last; node != null; node = node.previous) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
    }

    public int length() {
        int len = 0;
        Node node = first;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public int length2() {
        int len = 0;
        for (Node node = first; node != null; node = node.next, len++);
        return len;
    }

    public void insertAfter(E existingItem, E newItem) {
        Node<E> curNode = first;
        while (!curNode.data.equals(existingItem) &&
               (curNode.next != null)) {
            curNode = curNode.next;
        }
        Node<E> newNode = new Node<E>(newItem, curNode.next, curNode);
        if (newNode.next == null) {
            // No existing item, or existing item is last
            last = newNode;
        } else {
            // Inserting between two nodes, set previous reference
            // in new next mode
            curNode.next.previous = newNode;
        }
        curNode.next = newNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> lst = new DoublyLinkedList<>();
        lst.addFront("Thorny");
        lst.addFront("Farva");
        lst.addFront("Mac");
        lst.addFront("Rabbit");
        lst.addFront("Foster");
        lst.addFront("Ursula");
        lst.addFront("Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.remove(0);
        System.out.println("After lst.remove(0): " + lst);
        lst.remove(2);
        System.out.println("After lst.remove(2): " + lst);
        lst.remove(4);
        System.out.println("After lst.remove(4) (last element): " + lst);
        System.out.println("toReverseString still works: "
            + lst.toReverseString());

        lst.remove(22);
        System.out.println("After lst.remove(22): " + lst);
        lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        System.out.println("In reverse: ");
        System.out.println(lst.toReverseString());
    }
}

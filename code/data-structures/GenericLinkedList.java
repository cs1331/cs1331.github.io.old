public class GenericLinkedList<E> {

    protected class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    protected Node<E> head;

    public GenericLinkedList() {
        head = null;
    }

    /**
     * Add a new item to the front of this list.
     */
    public void addFront(E item) {
        head = new Node<E>(item, head);
    }

    public void add(E item) {
        Node<E> newNode = new Node<E>(item, null);
        Node<E> lastNode = head;
        if (null == head) {
            head = newNode;
        } else {
            while(lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    /**
     * Return the item at the front of this list and remove it from the list.
     */
    public E removeFront() {
        if (null == head) {
            throw new RuntimeException("Can't removeFront() on empty list.");
        }
        E answer = head.data;
        head = head.next;
        return answer;
    }

    /**
     * The number of items in this list.
     */
    public int length() {
        int len = 0;
        Node node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * @return true if this list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (Node node = head; node != null; node = node.next) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
    }

    public String toString2() {
        return "[" + toStringHelper(head, "") + "]";
    }

    private String toStringHelper(Node<E> node, String accum) {
        if (node == null) {
            return accum;
        } else {
            return toStringHelper(node.next, accum + node.data + ",");
        }
    }

    public int length2() {
        int len = 0;
        for (Node<E> node = head; node != null; node = node.next, len++);
        return len;
    }

    public void insertAfter(E existingItem, E newItem) {
        Node<E> curNode = head;
        while (!curNode.data.equals(existingItem) &&
               (curNode.next != null)) {
            curNode = curNode.next;
        }
        Node<E> newNode = new Node<E>(newItem, curNode.next);
        curNode.next = newNode;
    }

    public E get(int index) {
        // Guard condition: empty list
        if (null == head) { return null; }
        Node<E> curNode = head;
        while (index > 0) {
            if (curNode.next == null) {
                return null;
            }
            curNode = curNode.next;
            index--;
        }
        return curNode.data;
    }

    public boolean remove(E existingItem) {
        // Guard condition: empty list
        if (null == head) { return false; }
        boolean wasModified = false;
        Node<E> curNode = head;
        Node<E> previous = null;
        while (!existingItem.equals(curNode.data) &&
               (curNode.next != null)) {
            previous = curNode;
            curNode = curNode.next;
        }
        if (previous == null) {
            // removing head node
            head = curNode.next;
            wasModified = true;
        } else if (curNode.data.equals(existingItem)) {
            previous.next = curNode.next;
            wasModified = true;
        }
        return wasModified;
    }

    public static void main(String[] args) {
        GenericLinkedList<String> lst = new GenericLinkedList<>();
        lst.addFront("Thorny");
        lst.addFront("Farva");
        lst.addFront("Mac");
        lst.addFront("Rabbit");
        lst.addFront("Foster");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());

        lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());


        System.out.println("get(1): " + lst.get(1));
        System.out.println("get(8) (index out of bounds): " + lst.get(8));

        lst.remove("Foster");
        System.out.println("Removing Foster: " + lst);

        lst.remove("Mac");
        System.out.println("Removing Mac: " + lst);

        lst.remove("Chimpo");
        System.out.println("Removing Chimpo: " + lst);

        lst.remove("Foo");
        System.out.println("Removing Foo: " + lst);

        GenericLinkedList<String> nutherList = new GenericLinkedList<>();
        nutherList.remove("Foo");
        System.out.println("Removing Foo from empty list: " + nutherList);

    }
}

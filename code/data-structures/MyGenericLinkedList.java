public class MyGenericLinkedList<E> {

    private class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    
    /**
     * Add a new item to the head of this list.
     */
    public void add(E item) {
        head = new Node<>(item, head);
    }

    /**
     * Return the item at the head of this list and remove it from this list.
     */
    public E removeHead() {
        if (null == head) {
            throw new RuntimeException("Can't removeHead() on empty list.");
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
        Node<E> node = head;
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
        for (Node<E> node = head; node != null; node = node.next) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
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

    public static void main(String[] args) {
        LinkedList lst = new LinkedList();
        lst.add("Thorny");
        lst.add("Farva");
        lst.add("Mac");
        lst.add("Rabbit");
        lst.add("Foster");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());

        // Insert after existing item
        lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());

        // Insert after non-existing item - goes to tail of list
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
    }
}

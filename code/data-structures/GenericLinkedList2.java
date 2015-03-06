public class GenericLinkedList2<E> {

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            setNext(next);
        }

        public E getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node front;

    public GenericLinkedList2() {
        front = null;
    }

    public void addToFront(E item) {
        front = new Node(item, front);
    }

    public E removeFront() {
        if (null == front) {
            throw new RuntimeException("Can't removeFront() on empty list.");
        }
        E answer = front.getData();
        front = front.getNext();
        return answer;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (Node node = front; node != null; node = node.getNext()) {
            sb.append(node.getData() + " ");
        }
        return sb.toString() + "]";
    }

    public int length() {
        int len = 0;
        Node node = front;
        while (node != null) {
            len++;
            node = node.getNext();
        }
        return len;
    }

    public int length2() {
        int len = 0;
        for (Node node = front; node != null; node = node.getNext(), len++);
        return len;
    }

    public void insertAfter(E existingItem, E newItem) {
        Node curNode = front;
        while (!curNode.getData().equals(existingItem) &&
               (curNode.getNext() != null)) {
            curNode = curNode.getNext();
        }
        Node newNode = new Node(newItem, curNode.getNext());
        curNode.setNext(newNode);
    }

    public static void main(String[] args) {
        GenericLinkedList2<String> lst = new GenericLinkedList2<>();
        lst.addToFront("Thorny");
        lst.addToFront("Farva");
        lst.addToFront("Mac");
        lst.addToFront("Rabbit");
        lst.addToFront("Foster");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());

        lst.insertAfter("Rabbit", "Ursula");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
        lst.insertAfter("Spread it on!", "Chimpo");
        System.out.println(lst);
        System.out.println("How many? " + lst.length());
    }
}

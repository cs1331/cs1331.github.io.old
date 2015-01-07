public class LinkedList {

    private class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    /**
     * Add a new item to the head of this list.
     */
    public void add(Object item) {
        head = new Node(item, head);
    }

    /**
     * Return the item at the head of this list and remove it from this list.
     */
    public Object removeHead() {
        if (null == head) {
            throw new RuntimeException("Can't removeHead() on empty list.");
        }
        Object answer = head.data;
        head = head.next;
        return answer;
    }

    /**
     * The number of items in this list.  See slide 9.
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

    public int len() {
        return lenIter(head, 0);
    }

    public int lenIter(Node node, int accum) {
        if (null == node) {
            return accum;
        } else {
            return lenIter(node.next, accum + 1);
        }
    }

    /**
     * @return true if this list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node node = head; node != null; node = node.next) {
            sb.append(node.data + " ");
        }
        return sb.toString() + "]";
    }


    // See slide 8
    public void insertAfter(Object existingItem, Object newItem) {
        Node curNode = head;
        while (!curNode.data.equals(existingItem) &&
               (curNode.next != null)) {
            curNode = curNode.next;
        }
        Node newNode = new Node(newItem, curNode.next);
        curNode.next = newNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list);
        System.out.println("list.length(): " + list.length());
        System.out.println("list.len() " + list.len());

        list.add("Thorny");
        list.add("Farva");
        list.add("Mac");
        list.add("Rabbit");
        list.add("Foster");
        System.out.println(list);
        System.out.println("list.length(): " + list.length());
        System.out.println("list.len() " + list.len());

        // Insert after existing item
        list.insertAfter("Rabbit", "Ursula");
        System.out.println(list);
        System.out.println("list.length(): " + list.length());
        System.out.println("list.len() " + list.len());

        // Insert after non-existing item - goes to tail of list
        list.insertAfter("Wonder Woman", "Chimpo");
        System.out.println(list);
        System.out.println("list.length(): " + list.length());
        System.out.println("list.len() " + list.len());
    }
}

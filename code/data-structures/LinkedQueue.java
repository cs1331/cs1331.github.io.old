import java.util.ArrayList;

public class LinkedQueue<E> {
    
    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> last;

    public void enqueue(E item) {
        Node<E> newNode = new Node<E>(item, null);
        if (null == head) head = newNode;
        if (null != last) last.next = newNode;
        last = newNode;
    }
    
    public E dequeue() {
        E answer = head.data;
        head = head.next;
        return answer;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }


    public static void main(String[] args) {
        LinkedQueue<Integer> ints = new LinkedQueue<>();
        ints.enqueue(1);
        ints.enqueue(2);
        ints.enqueue(3);
        System.out.println(ints.dequeue());
        System.out.println(ints.dequeue());
        System.out.println(ints.dequeue());
    }
}

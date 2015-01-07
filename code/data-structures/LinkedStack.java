public class LinkedStack<E> extends AbstractStack<E> {

    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public void push(E item) {
        head = new Node<E>(item, head);
    }

    public E removeNext() {
        E answer = head.data;
        head = head.next;
        return answer;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public static void main(String[] args) {
        Stack<Integer> ints = new LinkedStack<>();
        ints.push(1);
        ints.push(2);
        ints.push(3);

        System.out.println(ints.pop());
        System.out.println(ints.pop());
        System.out.println(ints.pop());
        System.out.println(ints.pop());

    }
}

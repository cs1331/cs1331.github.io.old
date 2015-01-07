import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<? super E>>
        implements Iterable<E> {

    protected class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;

        Node(E item, Node<E> left, Node<E> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    protected class InOrderIterator<E> implements Iterator<E> {

        Node<E> curNode;
        // fringe is the to-do list of unprocessed nodes.
        Stack<Node<E>> fringe;

        public InOrderIterator(Node<E> root) {
            curNode = root;
            fringe = new LinkedStack<>();
        }

        public boolean hasNext() {
            return (curNode != null) || !fringe.isEmpty();
        }

        // Take note of:
        // - the bookkeeping required to implement a stateful iterator
        // - the use of another data structure (a stack) in the algorithm
        // - how much more complicated this is than the simple traversals
        public E next() {
            // Find the leftmost subtree Node of the current node, pushing
            // nodes along the way down the left sub-branch to deal with later
            while (curNode != null) {
                fringe.push(curNode);
                curNode = curNode.left;
            }
            // Process the deepest left subtree Node
            // This will be the current node if there's no left subtree
            curNode = fringe.pop();
            // Store its item to return
            E item = curNode.item;
            // Make the right subtree of the deepest left subtree Node
            // the current node to be processed on the next call to next().
            curNode = curNode.right;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected Node<E> root;

    public void add(E item) {
        root = insert(item, root);
    }

    protected Node<E> insert(E newItem, Node<E> node) {
        if (node == null) {
            return new Node<E>(newItem, null, null);
        } else if (newItem.compareTo(node.item) < 0) {
            node.left = insert(newItem, node.left);
            return node;
        } else {
            node.right = insert(newItem, node.right);
            return node;
        }
    }

    public boolean contains(E item) {
        return findNode(item, root) != null;
    }

    /**
     * @return The Node containing the item, or null if the item is not in
     *         any of the tree's nodes.
     */
    private Node<E> findNode(E queryItem, Node<E> node) {
        if (null == node) {
            return null;
        } else if (node.item.equals(queryItem)) {
            return node;
        } else if (queryItem.compareTo(node.item) < 0) {
            return findNode(queryItem, node.left);
        } else {
            return findNode(queryItem, node.right);
        }
    }

    public Iterator<E> iterator() {
        return new InOrderIterator<E>(root);
    }

    // Simple traversals
    public void printPreOrder() { printPreOrder(root); }
    public void printInOrder() { printInOrder(root); }
    public void printPostOrder() { printPostOrder(root); }

    private void printPreOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.item + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printInOrder(Node<E> node) {
        if (node != null) {
            printInOrder(node.right);
            System.out.print(node.item + " ");
            printInOrder(node.left);
        }
    }

    private void printPostOrder(Node<E> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.item + " ");
        }
    }

    // Exercise: how would you print the items in reverse (descending) order?


    public List<E> toList() {
        return inOrderList(root, new ArrayList<E>());
    }

    private List<E> inOrderList(Node<E> node, List<E> accum) {
        if (null == node) {
            return accum;
        } else {
            inOrderList(node.left, accum);
            accum.add(node.item);
            inOrderList(node.right, accum);
        }
        return accum;
    }

    public List<E> inOrderImperative() {
        Node<E> curNode = root;
        // fringe is the to-do list of unprocessed nodes.
        Stack<Node<E>> fringe = new LinkedStack<>();
        List<E> accum = new ArrayList<E>();
        while ((curNode != null) || !fringe.isEmpty()) {
            // Find the leftmost subtree Node of the current node, pushing
            // nodes along the way down the left sub-branch to deal with later
            while (curNode != null) {
                fringe.push(curNode);
                curNode = curNode.left;
            }
            // Process the deepest left subtree Node
            // This will be the current node if there's no left subtree
            curNode = fringe.pop();
            // Add current item to accumulating list
            accum.add(curNode.item);
            // Make the right subtree of the deepest left subtree Node
            // the current node to be processed next
            curNode = curNode.right;
        }
        return accum;
    }

    @Override
    public String toString() {
        String elements = toStringHelper(root, new StringBuilder()).toString();
        return "[" + elements.substring(0, elements.length() -2) + "]";
    }

    private StringBuilder toStringHelper(Node<E> node, StringBuilder accum) {
        if (null == node) {
            return accum;
        } else {
            toStringHelper(node.left, accum);
            accum.append(node.item + ", ");
            toStringHelper(node.right, accum);
        }
        return accum;
    }

    public List<E> path(E queryItem) {
        Node<E> curNode = root;
        List<E> pathList = new ArrayList<>();
        boolean found = false;
        while (curNode != null && !found) {
            if (queryItem.equals(curNode.item)) {
                pathList.add(queryItem);
                found = true;
            } else if (queryItem.compareTo(curNode.item) < 0) {
                pathList.add(curNode.item);
                curNode = curNode.left;
            } else {
                pathList.add(curNode.item);
                curNode = curNode.right;
            }
        }
        return found ? pathList : new ArrayList<E>();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> nums = new BinarySearchTree<>();
        List<Integer> toBeAdded = Arrays.asList(3, 4, 1, 5, 2);
        System.out.println("Elements to be added: " + toBeAdded);
        for (Integer element: toBeAdded) nums.add(element);
        System.out.println("Starting BST: " + nums.toString());
        System.out.println("Path to 1: " + nums.path(1));
        System.out.println("Path to 2: " + nums.path(2));
        System.out.println("Path to 3: " + nums.path(3));
        System.out.println("Path to 4: " + nums.path(4));
        System.out.println("Path to 5: " + nums.path(5));
        System.out.println("Path to 6: " + nums.path(6));
        // Print using simple traversals
        System.out.print("Pre-order: ");
        nums.printPreOrder();
        System.out.println();
        System.out.print("In-order: ");
        nums.printInOrder();
        System.out.println();
        System.out.print("Post-order: ");
        nums.printPostOrder();
        System.out.println();
        // System.out.print("Descending: ");
        // nums.printDescending();
        // System.out.println();

        // Print using iterator.
        for (Integer num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Confirm that contains works.
        for (int i = 0; i < 7; i++) {
            System.out.printf("nums.contains(%d) == %b%n", i, nums.contains(i));
        }

        System.out.println("nums.toList() (recursive): " + nums.toList());
        System.out.println("inOrderImperative(): " + nums.inOrderImperative());
    }
}

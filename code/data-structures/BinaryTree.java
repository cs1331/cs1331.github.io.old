import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {
    
    private class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;
        
        Node(E item, Node<E> left, Node<E> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
    
    private class InOrderIterator<E> implements Iterator<E> {
        
        Node<E> curNode;
        // fringe is the to-do list of unvisited nodes.
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
    
    private Node<E> root;
    
    public void add(E item) {
        root = insert(item, root);
    }

    private Node<E> insert(E item, Node<E> node) {
        if (node == null) {
            return new Node<E>(item, null, null);
        } else if (item.compareTo(node.item) < 0) {
            node.left = insert(item, node.left);
            return node;
        } else {
            node.right = insert(item, node.right);
            return node;
        }
    }

    public boolean contains(E item) {
        return find(item, root) != null;
    }

    /**
     * @todo Implement for reals.  Currently returns null.
     *
     * @return The Node containing the item, or null if the item is not in
     *         any of the tree's nodes.
     */
    private Node<E> find(E item, Node<E> node) {
        return null;
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
            printInOrder(node.left);
            System.out.print(node.item + " ");
            printInOrder(node.right);
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

    public void printDescending() {
        printDescending(root);
    }

    public void printDescending(Node<E> node) {
        if (node != null) {
            printDescending(node.right);
            System.out.print(node.item + " ");
            printDescending(node.left);
        }
    }

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

    public static void main(String[] args) {
        BinaryTree<Integer> nums = new BinaryTree<>();
        nums.add(3);
        nums.add(4);
        nums.add(1);
        nums.add(5);
        nums.add(2);

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
        System.out.print("Descending: ");
        nums.printDescending();
        System.out.println();

        // Print using iterator.
        for (Integer num: nums) {
            System.out.println(num + " ");
        }
        // Confirm that contains works.
        for (int i = 0; i < 7; i++) {
            System.out.printf("nums.contains(%d) == %b%n", i, nums.contains(i));
        }

        System.out.println(nums.toList());
    }
}

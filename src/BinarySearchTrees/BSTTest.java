package BinarySearchTrees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by akash on 10/08/17.
 */
public class BSTTest {
    private BST<Integer, String> bst;

    @Before
    public void setUp() throws Exception {
        Node<Integer, String> root = new Node<>(5, "Five");
        root.left = new Node<>(1, "One");
        root.left.right = new Node<>(3, "Three");
        root.right = new Node<>(10, "Ten");
        root.right.left = new Node<>(9, "Nine");
        bst = new BST<>(root);
    }

    @Test
    public void bstCreate() throws Exception  {
        Node<Integer, String> root = new Node<>(6, "Six");
        this.bst = new BST<>(root);
        assertEquals(this.bst.getRoot(), root);
    }

    @Test
    public void put() throws Exception {
        this.bst.put(20, "Twenty");
        assertEquals("Twenty", this.bst.get(20));
        this.bst.put(-10, "MinusTen");
        assertEquals("MinusTen", this.bst.get(-10));
        this.bst.put(-10, "NewMinusTen");
        assertEquals("NewMinusTen", this.bst.get(-10));
        this.bst.put(5, "NewRoot");
        assertEquals("NewRoot", this.bst.get(5));
    }

    @org.junit.Test
    public void get() throws Exception {
        assertEquals("Five", this.bst.get(5));
        assertEquals(null, this.bst.get(1000));
        assertEquals("One", this.bst.get(1));
        assertEquals("Three", this.bst.get(3));
        assertEquals("Ten", this.bst.get(10));
        assertEquals("Nine", this.bst.get(9));
    }

}
package BinarySearchTrees;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.portable.Streamable;
import org.xml.sax.SAXException;

import static org.junit.Assert.*;

/**
 * Created by akash on 10/08/17.
 */
public class BSTTest {
    private BST<Integer, String> bst;

    @Before
    public void setUp() throws Exception {
        Node<Integer, String> root = new Node<>(5, "Five", 5);
        root.left = new Node<>(1, "One", 2);
        root.left.right = new Node<>(3, "Three", 1);
        root.right = new Node<>(10, "Ten", 2);
        root.right.left = new Node<>(9, "Nine", 1);
        bst = new BST<>(root);
    }

    @Test
    public void bstCreate() throws Exception  {
        Node<Integer, String> root = new Node<>(6, "Six", 1);
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

    @Test
    public void get() throws Exception {
        assertEquals("Five", this.bst.get(5));
        assertEquals(null, this.bst.get(1000));
        assertEquals("One", this.bst.get(1));
        assertEquals("Three", this.bst.get(3));
        assertEquals("Ten", this.bst.get(10));
        assertEquals("Nine", this.bst.get(9));
    }

    @Test
    public void min() throws Exception {
        Node<Integer, String> minNode = this.bst.min();
        assertEquals(minNode.key.intValue(), 1);
        assertEquals(minNode.value, "One");
    }

    @Test
    public void max() throws Exception {
        Node<Integer, String> maxNode = this.bst.max();
        assertEquals(maxNode.key.intValue(), 10);
        assertEquals(maxNode.value, "Ten");
    }

    @Test
    public void floor() throws Exception {
        int key = this.bst.floor(10);
        assertEquals(key, 10);
        assertEquals(this.bst.get(key), "Ten");
        assertEquals(this.bst.floor(11).intValue(), 10);
        assertEquals(this.bst.floor(0), null);
        assertEquals(this.bst.floor(6).intValue(), 5);
    }

    @Test
    public void ceiling() throws Exception {
        int key = this.bst.ceiling(3);
        assertEquals(key, 3);
        assertEquals(this.bst.get(key), "Three");
        assertEquals(this.bst.ceiling(0).intValue(), 1);
        assertEquals(this.bst.ceiling(11), null);
        assertEquals(this.bst.ceiling(4).intValue(), 5);
    }

    @Test
    public void size() throws Exception {
        assertEquals(this.bst.size(), 5);
        BST<Integer, Integer> bst2 = new BST<>();
        int[] arr = {5, 3, 7, 10, 0, 14};
        for (int a: arr) bst2.put(a, a);
        assertEquals(bst2.size(), 6);
    }

}
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
        assertEquals(1, minNode.key.intValue());
        assertEquals("One", minNode.value);
    }

    @Test
    public void max() throws Exception {
        Node<Integer, String> maxNode = this.bst.max();
        assertEquals(10, maxNode.key.intValue());
        assertEquals("Ten", maxNode.value);
    }

    @Test
    public void floor() throws Exception {
        int key = this.bst.floor(10);
        assertEquals(10, key);
        assertEquals("Ten", this.bst.get(key));
        assertEquals(10, this.bst.floor(11).intValue());
        assertEquals(null, this.bst.floor(0));
        assertEquals(5, this.bst.floor(6).intValue());
    }

    @Test
    public void ceiling() throws Exception {
        int key = this.bst.ceiling(3);
        assertEquals(3, key);
        assertEquals("Three", this.bst.get(key));
        assertEquals(1, this.bst.ceiling(0).intValue());
        assertEquals(null, this.bst.ceiling(11));
        assertEquals(5, this.bst.ceiling(4).intValue());
    }

    @Test
    public void size() throws Exception {
        assertEquals(5, this.bst.size());
        BST<Integer, Integer> bst2 = new BST<>();
        int[] arr = {5, 3, 7, 10, 0, 14};
        for (int a: arr) bst2.put(a, a);
        assertEquals(6, bst2.size());
    }

    @Test
    public void rank() throws Exception {
        assertEquals(2, this.bst.rank(5));
        assertEquals(0, this.bst.rank(0));
        assertEquals(5, this.bst.rank(11));
        assertEquals(0, this.bst.rank(1));
        assertEquals(4, this.bst.rank(10));
    }

}
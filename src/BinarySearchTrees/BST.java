package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akash on 10/08/17.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

    public BST() {}

    public BST(Node<Key, Value> root) {
        this.root = root;
    }

    public Node<Key, Value> getRoot() {
        return root;
    }

    public Value get(Key key) {
        return get(this.root, key);
    }

    private Value get(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        if (cmp > 0) return get(node.right, key);
        else         return node.value;
    }

    public void put(Key key, Value value) {
        this.root = put(this.root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) return new Node<>(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        if (cmp > 0) node.right = put(node.right, key, value);
        else         node.value = value;
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Node<Key, Value> min() {
        return min(this.root);
    }

    private Node<Key, Value> min(Node<Key, Value> node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Node<Key, Value> max() {
        return max(this.root);
    }

    private Node<Key, Value> max(Node<Key, Value> node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public Key floor(Key key) {
        Node<Key, Value> floorNode = floor(this.root, key);
        if (floorNode == null) return null;
        return floorNode.key;
    }

    private Node<Key, Value> floor(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0)  return this.floor(node.left, key);
        // if (cmp > 0)
        Node<Key, Value> temp = this.floor(node.right, key);
        if (temp == null) return node;
        else              return temp;
    }

    public Key ceiling(Key key) {
        Node<Key, Value> ceilingNode = ceiling(this.root, key);
        if (ceilingNode == null) return null;
        return ceilingNode.key;
    }

    private Node<Key, Value> ceiling(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp > 0)  return this.ceiling(node.right, key);
        // if (cmp < 0)
        Node<Key, Value> temp = this.ceiling(node.left, key);
        if (temp == null) return node;
        else              return temp;
    }

    public int size() {
        return this.size(this.root);
    }

    private int size(Node<Key, Value> node) {
        if (node == null) return 0;
        return node.count;
    }

    public int rank(Key key) {
        return this.rank(this.root, key);
    }

    private int rank(Node<Key, Value> node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return this.size(node.left);
        if (cmp < 0)  return this.rank(node.left, key);
        else          return 1 + this.size(node.left) + this.rank(node.right, key);
    }

    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<>();
        inorder(this.root, list);
        return list;
    }

    private void inorder(Node<Key, Value> node, List<Key> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.key);
        inorder(node.right, list);
    }
}

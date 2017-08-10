package BinarySearchTrees;

/**
 * Created by akash on 10/08/17.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

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
        if (node == null) return new Node<>(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        if (cmp > 0) node.right = put(node.right, key, value);
        else         node.value = value;
        return node;
    }
}

package BinarySearchTrees;

/**
 * Created by akash on 10/08/17.
 */
public class Node<Key extends Comparable<Key>, Value> {
    Key key;
    Value value;
    Node<Key, Value> left, right;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}

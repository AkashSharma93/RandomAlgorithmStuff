package BinarySearchTrees;

/**
 * Created by akash on 10/08/17.
 */
public class Node<Key extends Comparable<Key>, Value> {
    Key key;
    Value value;
    Node<Key, Value> left, right;
    int count;

    public Node(Key key, Value value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }
}

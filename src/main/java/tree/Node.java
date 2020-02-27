package tree;

public class Node<V> {
    private final V value;
    private Node<V> leftNode;
    private Node<V> rightNode;

    public Node(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public Node<V> getLeftNode() {
        return leftNode;
    }

    public Node<V> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node<V> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<V> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}

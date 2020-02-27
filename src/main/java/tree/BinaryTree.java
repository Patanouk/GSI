package tree;

public class BinaryTree<V> {
    private final Node<V> root;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<V> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeftNode()), height(node.getRightNode()));
    }

    public boolean isBalancedQuadratic() {
        return isBalancedQuadratic(root);
    }

    private boolean isBalancedQuadratic(Node<V> node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.getLeftNode()) - height(node.getRightNode())) <= 1
                && isBalancedQuadratic(node.getLeftNode())
                && isBalancedQuadratic(node.getRightNode());
    }
}

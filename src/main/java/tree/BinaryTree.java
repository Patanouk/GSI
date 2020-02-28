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

    public boolean isBalancedLinear() {
        return isBalancedLinear(new NodeWithHeight(root));
    }

    private boolean isBalancedLinear(NodeWithHeight nodeWithHeight) {
        if (nodeWithHeight.getNode() == null) {
            nodeWithHeight.setHeight(0);
            return true;
        }

        NodeWithHeight leftNodeWithHeight = new NodeWithHeight(nodeWithHeight.getNode().getLeftNode());
        NodeWithHeight rightNodeWithHeight = new NodeWithHeight(nodeWithHeight.getNode().getRightNode());

        boolean leftTreeBalanced = isBalancedLinear(leftNodeWithHeight);
        boolean rightTreeBalanced = isBalancedLinear(rightNodeWithHeight);

        nodeWithHeight.setHeight(1 + Math.max(leftNodeWithHeight.getHeight(), rightNodeWithHeight.getHeight()));

        if (Math.abs(leftNodeWithHeight.getHeight() - rightNodeWithHeight.getHeight()) > 1) {
            return false;
        }

        return leftTreeBalanced && rightTreeBalanced;
    }

    public String inOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        inOrder(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void inOrder(StringBuilder stringBuilder, Node<V> node) {
        if (node == null) {
            return;
        }
        inOrder(stringBuilder, node.getLeftNode());
        stringBuilder.append(node.getValue()).append(" ");
        inOrder(stringBuilder, node.getRightNode());
    }

    public String preOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        preOrder(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void preOrder(StringBuilder stringBuilder, Node<V> node) {
        if (node == null) {
            return;
        }
        stringBuilder.append(node.getValue()).append(" ");
        preOrder(stringBuilder, node.getLeftNode());
        preOrder(stringBuilder, node.getRightNode());
    }

    public String postOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        postOrder(stringBuilder, root);
        return stringBuilder.toString();
    }

    private void postOrder(StringBuilder stringBuilder, Node<V> node) {
        if (node == null) {
            return;
        }
        postOrder(stringBuilder, node.getLeftNode());
        postOrder(stringBuilder, node.getRightNode());
        stringBuilder.append(node.getValue()).append(" ");
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    private class NodeWithHeight {
        private final Node<V> node;
        private int height;

        public NodeWithHeight(Node<V> node) {
            this.node = node;
        }

        public Node<V> getNode() {
            return node;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}

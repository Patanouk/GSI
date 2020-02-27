package tree;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BinaryTreeTest {

    @Test
    public void testIsBalanced() {
        BinaryTree<String> tree = new BinaryTree<>(null);
        assertTrue(tree.isBalancedQuadratic());

        Node<String> root = new Node<>("1");
        BinaryTree<String> tree2 = new BinaryTree<>(root);
        assertTrue(tree2.isBalancedQuadratic());

        root.setLeftNode(new Node<>("1.1"));
        assertTrue(tree2.isBalancedQuadratic());

        root.setRightNode(new Node<>("1.2"));
        assertTrue(tree2.isBalancedQuadratic());

        root.getRightNode().setRightNode(new Node<>("1.2.2"));
        root.getRightNode().getRightNode().setLeftNode(new Node<>("1.2.2.2"));
        assertFalse(tree2.isBalancedQuadratic());

        root.getLeftNode().setLeftNode(new Node<>("1.1.1"));
        assertFalse(tree2.isBalancedQuadratic());
    }
}
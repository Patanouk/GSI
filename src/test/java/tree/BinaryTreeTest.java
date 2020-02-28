package tree;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BinaryTreeTest {

    @Test
    public void testIsBalanced() {
        BinaryTree<String> tree = new BinaryTree<>(null);
        assertTrue(tree.isBalancedQuadratic());
        assertTrue(tree.isBalancedLinear());

        Node<String> root = new Node<>("1");
        BinaryTree<String> tree2 = new BinaryTree<>(root);
        assertTrue(tree2.isBalancedQuadratic());
        assertTrue(tree2.isBalancedLinear());

        root.setLeftNode(new Node<>("1.1"));
        assertTrue(tree2.isBalancedQuadratic());
        assertTrue(tree2.isBalancedLinear());

        root.setRightNode(new Node<>("1.2"));
        assertTrue(tree2.isBalancedQuadratic());
        assertTrue(tree2.isBalancedLinear());

        root.getRightNode().setRightNode(new Node<>("1.2.2"));
        root.getRightNode().getRightNode().setLeftNode(new Node<>("1.2.2.2"));
        assertFalse(tree2.isBalancedQuadratic());
        assertFalse(tree2.isBalancedLinear());

        root.getLeftNode().setLeftNode(new Node<>("1.1.1"));
        assertFalse(tree2.isBalancedQuadratic());
        assertFalse(tree2.isBalancedLinear());
    }

    @Test
    public void testTraverseTree() {
        Node<Integer> root = new Node<>(1);
        root.setLeftNode(new Node<>(2));
        root.setRightNode(new Node<>(3));
        root.getLeftNode().setLeftNode(new Node<>(4));
        root.getLeftNode().setRightNode(new Node<>(5));
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        System.out.println("InOrder : " + tree.inOrder());
        System.out.println("PreOrder : " + tree.preOrder());
        System.out.println("PostOrder : " + tree.postOrder());
    }

    @Test
    public void testVerticalOrderTree() {
        Node<Integer> root = new Node<>(1);
        root.setLeftNode(new Node<>(2));
        root.setRightNode(new Node<>(3));
        root.getLeftNode().setLeftNode(new Node<>(4));
        root.getLeftNode().setRightNode(new Node<>(5));
        root.getRightNode().setLeftNode(new Node<>(6));
        root.getRightNode().setRightNode(new Node<>(7));
        root.getRightNode().getLeftNode().setRightNode(new Node<>(8));
        root.getRightNode().getRightNode().setRightNode(new Node<>(9));
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        System.out.println(tree.verticalOrder());
    }
}
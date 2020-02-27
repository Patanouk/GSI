package tree;

public class SortedArrayToBalancedBst {

    public static <T> BinaryTree<T> arrayToBalancedBinaryTree(T[] input) {
        return new BinaryTree<>(arrayToBalancedBinaryTree(input, 0, input.length - 1));
    }

    private static <T> Node<T> arrayToBalancedBinaryTree(T[] input, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        T rootElement = input[mid];
        Node<T> root = new Node<>(rootElement);

        root.setLeftNode(arrayToBalancedBinaryTree(input, start, mid - 1));
        root.setRightNode(arrayToBalancedBinaryTree(input, mid + 1, end));

        return root;
    }
}

package trees;

import java.util.Deque;
import java.util.LinkedList;

public class CheckBST {
    public static void main(String[] args) {

        Node rootNode = new Node(2);
        rootNode.left = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(-1);
        rootNode.left.right = new Node(0);
        System.out.println(isBST(rootNode));
        System.out.println(isBSTIterative(rootNode));
    }

    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.key <= minValue || root.key >= maxValue) return false;
        return isBST(root.left, minValue, root.key) && isBST(root.right, root.key, maxValue);
    }


    private static boolean isBSTIterative(Node root) {
        if (root == null) {
            return true;
        }

        Deque<Node> stack = new LinkedList<>();
        Node node = root;
        int prev = Integer.MIN_VALUE;
        int current;
        while (true) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pollFirst();
                current = node.key;
                if (current < prev) {
                    return false;
                }
                prev = current;
                node = node.right;
            }
        }
        return true;

    }
}

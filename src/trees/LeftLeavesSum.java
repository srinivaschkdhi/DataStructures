
package trees;

import java.util.Stack;

public final class LeftLeavesSum {
    public static int sumOfLeftLeaves(Node root) {
        if (root == null) {
            return 0;
        }

        int sumOfLtLvs = 0;

        Stack<Node> stack = new Stack<>();//Can be implemented using queue also.
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();

            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {//whenever you ar going to left node , checking if it is leaf node.
                    sumOfLtLvs += root.left.key;
                } else {
                    stack.push(root.left);
                }
            }

            if (root.right != null) {
                if (root.right.left != null || root.right.right != null) { // if not leaf node add to stack only
                    stack.push(root.right);
                }
            }
        }

        return sumOfLtLvs;
    }

    public static void main(String[] args) {
        Node rootNode = new Node(3);
        rootNode.left = new Node(9);
        rootNode.right = new Node(20);
        rootNode.right.left = new Node(15);
        rootNode.right.right = new Node(7);

        int i = sumOfLeftLeaves(rootNode);
        System.out.println("i = " + i);
    }
}

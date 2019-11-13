
package trees;

import java.util.Stack;


public final class RangeSumBST {
    public int rangeSumBST(Node root, int L, int R) {
        int rangeSum = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();

            if (root != null) {
                if (root.key >= L && root.key <= R) {
                    rangeSum += root.key;
                }

                if (root.key > L) {
                    stack.push(root.left);
                }

                if (root.key < R) {
                    stack.push(root.right);
                }
            }
        }

        return rangeSum;
    }

}

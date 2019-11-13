
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

    static int rangeSum = 0;

    public int rangeSumR(Node root, int L, int R) {
        getRangeSum(root, L, R);
        return rangeSum;
    }

    public static void getRangeSum(Node root, int L, int R) {
        if (root != null){
            if(root.key <=L && root.key >=R){
                rangeSum += root.key;
            }

            if(root.key > L)
                getRangeSum(root.left,L,R);

            if(root.key < R)
                getRangeSum(root.right,L,R);
        }
    }
}


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

                if (root.key > L) {// if root is not less than 7 . we dont go left.
                    stack.push(root.left);// as we dont need num < 7.
                }

                if (root.key < R) { // if root greater than 15 . we dont go right.
                    stack.push(root.right); // as we dont need num > 15
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

package trees;

import java.util.Stack;

public class KthSmallestEleInBST {
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        int currentNodeVal = 0;

        while (true) {
            if (root != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;
                node = stack.pop();
                currentNodeVal = node.key;

                k--;
                if (k == 0)
                    break;
                node = node.right;
            }
        }
        return currentNodeVal;
    }
}

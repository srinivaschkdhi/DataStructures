
package trees;

import java.util.Stack;


public class BTHasSum {
    public boolean hasPathSum(Node root, int sum) {
        Stack<Node> nodeStack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();

        nodeStack.add(root);
        stackSum.add(sum - root.key);

        while (!nodeStack.isEmpty()) {
            Node currNode = nodeStack.pop();
            int currSum = stackSum.pop();

            if (currNode.left == null && currNode.right == null && currSum == 0) {
                return true;
            }

            if (currNode.left != null) {
                nodeStack.add(currNode.left);
                stackSum.add(currSum - currNode.left.key);
            }

            if (currNode.right != null) {
                nodeStack.add(currNode.right);
                stackSum.add(currSum - currNode.right.key);
            }
        }

        return false;
    }
}

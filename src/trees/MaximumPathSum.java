
package trees;


public class MaximumPathSum {
    int maxPathSum = 0;

    public int maxPathSum(Node root) {
        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }

    public int pathSum(Node root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));

        maxPathSum = Math.max(maxPathSum, left + right + root.key);

        return Math.max(left, right) + root.key;
    }
}

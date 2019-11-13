
package trees;

public final class DistributeCoinsBT {
    int numMoves;

    public int distributeCoins(Node root) {
        numMoves = 0;
        giveCoins(root);
        return numMoves;
    }

    public int giveCoins(Node root) {
        if (root == null) {
            return 0;
        }

        int left = giveCoins(root.left);
        int right = giveCoins(root.right);
        numMoves += Math.abs(left) + Math.abs(right);

        return root.key + left + right - 1;
    }
}

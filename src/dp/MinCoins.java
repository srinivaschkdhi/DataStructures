/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class MinCoins {
    public int minCoins(int[] coins, int amount, int n) {
        if (amount == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (amount - coins[i] >= 0) {
                int eachPossibility = minCoins(coins, amount - coins[i], n);
                if (eachPossibility != Integer.MAX_VALUE)
                    ans = Math.min(ans, eachPossibility + 1);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int minCoins = new MinCoins().minCoins(new int[]{1, 2, 5, 10}, 39, 4);
        System.out.println("minCoins = " + minCoins);
    }
}

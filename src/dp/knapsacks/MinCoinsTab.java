/**
 * @author Srinivas_Chintakindhi
 */

package dp.knapsacks;

public class MinCoinsTab {
    public int minCoins(int[] coins, int amount, int n) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int rupay = 1; rupay <= amount; rupay++) {

            for (int i = 0; i < n; i++) {

                if (coins[i] <= rupay) {
                    int smallans = dp[rupay - coins[i]];

                    if (smallans != Integer.MAX_VALUE) {
                        dp[rupay] = Math.min(dp[rupay], smallans + 1);
                    }
                }
            }

        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int minCoins = new MinCoinsTab().minCoins(new int[]{1, 2, 5, 10}, 39, 4);
        System.out.println("minCoins = " + minCoins);
    }
}

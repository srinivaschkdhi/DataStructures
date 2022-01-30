/**
 * @author Srinivas_Chintakindhi
 */

package dp.knapsacks;

public class KnapsackTabl {
    public static int knapsackRecursion(int[] weights, int[] values, int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (weights[n - 1] <= W) {
            return Math.max(values[n - 1] +
                            knapsackRecursion(weights, values, W - weights[n - 1], n - 1),
                    knapsackRecursion(weights, values, W, n - 1)
            );
        } else {
            return knapsackRecursion(weights, values, W, n - 1);
        }
    }

    public static int knapSackTabl(int[] weights, int[] values, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (weights[i - 1] <= j)
                        dp[i][j] = Math.max(values[i - 1] +
                                        dp[i - 1][j - weights[i - 1]],
                                dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static int knapSackUnbounded(int[] weights, int[] values, int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (weights[n - 1] <= W) {
            return
                    Math.max(values[n - 1] + knapSackUnbounded(weights, values, W - weights[n - 1], n),
                            knapSackUnbounded(weights, values, W, n - 1));
        } else {
            return knapSackUnbounded(weights, values, W, n - 1);
        }
    }

    public static int knapSackUnboundedTabl(int[] weights, int[] values, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (weights[i - 1] <= j) {
                        dp[i][j] = Math.max(values[i - 1] + dp[i][j - weights[i - 1]],
                                dp[i - 1][j]);
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static int rodCutting(int[] lengths, int[] prices, int C, int n) {
        int[][] dp = new int[n + 1][C + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= C; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (lengths[i - 1] <= j) {
                        dp[i][j] = Math.max(prices[i - 1] + dp[i][j - prices[i - 1]],
                                dp[i - 1][j]);
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][C];
    }

    public static int numberOfWaysCoins(int[] coins, int amount, int n) {
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0)
                        dp[i][j] = 0;
                    if (j == 0)
                        dp[i][j] = 1;
                } else {
                    if (coins[i - 1] <= j) {
                        dp[i][j] = dp[i][j - coins[i - 1]] +
                                dp[i - 1][j];
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }


    public static int minOfWaysCoins(int[] coins, int amount, int n) {
        int[][] dp = new int[n + 1][amount + 1];

        for (int j = 0; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1, j = 1; j <= amount; j++)
            if (j % coins[0] == 0)
                dp[i][j] = j / coins[0];
            else
                dp[i][j] = Integer.MAX_VALUE - 1;


        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]],
                            dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        int wts[] = {1, 2};
        int prices[] = {1, 5};

        int N = 2;
        int W = 4;

        int knapsack = knapSackTabl(wts, prices, W, N);
        System.out.println("knapsack = " + knapsack);
    }
}

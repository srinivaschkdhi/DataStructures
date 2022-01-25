/**
 * @author Srinivas_Chintakindhi
 */

package dp;

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
        int[][] dp = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if(i == 0 || j == 0)
                    dp[i][j] =0;
                else{
                    if(weights[i-1] <= j)
                        dp[i][j] = Math.max(values[i-1] +
                                            dp[i-1][j-weights[i-1]],
                                            dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }


    public int knapsack(int[] wts, int[] price, int N, int W) {
        int[][] dp = new int[100][100];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int inc = 0;
                    int exec = 0;

                    if (wts[i - 1] <= j) {
                        inc = price[i - 1] + dp[i - 1][j - wts[i - 1]];
                    }

                    exec = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exec);
                }
            }
        }

        return dp[N][W];
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

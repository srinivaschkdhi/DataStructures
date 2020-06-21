/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class KnapsackTabl {
    public int knapsack(int[] wts, int[] price, int N, int W) {
        int[][] dp = new int[100][100];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    int inc = 0, exec = 0;

                    if (wts[i - 1] <= j) {
                        inc = price[i - 1] + dp[i - 1][j - wts[i - 1]];
                    }

                    exec = dp[i - 1][j];
                    dp[j][j] = Math.max(inc, exec);
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        int wts[] = {2, 7, 3, 4};
        int prices[ ] = {5,20,20,10};

        int N = 4;
        int W = 11;

        int knapsack = new KnapsackTabl().knapsack(wts, prices, N, W);
        System.out.println("knapsack = " + knapsack);

    }
}

package dp.knapsacks;

public class CountSubsetSum {
    public int countSubsetsSumRec(int n, int[] arr, int sum) {
        if (sum == 0)
            return 1;

        if (n == 0 && sum != 0)
            return 0;

        if (arr[n - 1] <= sum) {
            return
                    countSubsetsSumRec(n - 1, arr, sum - arr[n - 1]) +
                            countSubsetsSumRec(n - 1, arr, sum);
        } else {
            return countSubsetsSumRec(n - 1, arr, sum);
        }
    }

    public static int countSubsetsSum(int n, int[] arr, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (i == 0 || j == 0) {

                    if (i == 0)
                        dp[i][j] = 0;
                    if (j == 0)
                        dp[i][j] = 1;

                } else {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] +
                                dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }
}

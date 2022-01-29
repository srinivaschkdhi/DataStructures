package dp.strings;

public class LongestCommonSubsequenceRepat {
    public int lcsRepeat(String input) {
        int m = input.length();
        return lcsTabl(input, input, m, m);
    }

    public int lcsTabl(String x, String y, int m, int n) {
        // replace n - i
        // replace m - j
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1],
                                dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}

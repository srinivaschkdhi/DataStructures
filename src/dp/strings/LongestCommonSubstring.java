package dp.strings;

public class LongestCommonSubstring {
    public int lcs(String x, String y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return 1 + lcs(x, y, m - 1, n - 1);
        else
            return 0;
    }

    public int lcsTabl(String x, String y, int m, int n) {
        // replace n - i
        // replace m - j
        int[][] dp = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max,dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "abhati";

        int ans = new LongestCommonSubstring().lcsTabl(text1, text2, text1.length(), text2.length());
        System.out.println("ans = " + ans);
    }
}

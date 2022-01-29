package dp.strings;

public class LongestCommonSubsequence {
    int[][] lookup = new int[1001][1001];

    public int lcs(String x, String y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return 1 + lcs(x, y, m - 1, n - 1);
        else
            return
                    Math.max(
                            lcs(x, y, m, n - 1),
                            lcs(x, y, m - 1, n)
                    );
    }


    public int longestCommonSubsequence(String text1, String text2) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++)
                lookup[i][j] = -1;
        }

        return lcsMem(text1, text2, text1.length(), text2.length());
    }

    public int lcsMem(String x, String y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (lookup[m][n] != -1)
            return lookup[m][n];

        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            lookup[m][n] = 1 + lcsMem(x, y, m - 1, n - 1);
            return lookup[m][n];
        } else
            lookup[m][n] =
                    Math.max(
                            lcsMem(x, y, m, n - 1),
                            lcsMem(x, y, m - 1, n)
                    );
        return lookup[m][n];
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
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
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

    public String lcsStringTabl(String x, String y, int m, int n) {
        // replace n - i
        // replace m - j
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1],
                                dp[i - 1][j]);
                    }
                }
            }
        }

        return lcsStringFromMatrix(dp,x,y);
    }

    private String lcsStringFromMatrix(int[][] dp, String x, String y) {
        int i = dp.length - 1;
        int j = dp[i].length - 1;
        String subSequence = "";

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                subSequence = x.charAt(i - 1) + subSequence;
                i -= 1;
                j -= 1;
            } else {

                if (dp[i][j - 1] > dp[i - 1][j]) { // if left is max.move left
                    j--;
                } else {
                    i--;
                }

            }
        }

        return subSequence;
    }

    public static void main(String[] args) {
        String s = new LongestCommonSubsequence().lcsStringTabl("abcdeff", "asctff", 7, 6);
        System.out.println("s = " + s);
    }
}

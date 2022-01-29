package dp.strings;

public class ShortestCommonSuperSequence {
    public int lengthOfSuperSequence(String x, String y) {
        return x.length() + y.length() -
                new LongestCommonSubsequence().lcsTabl(x, y, x.length(), y.length());
    }

    public String superSequence(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] dp = lcsMatrix(x, y, m, n);
        return getsuperSequenceString(dp, x, y);
    }

    private String getsuperSequenceString(int[][] dp, String x, String y) {
        int i = dp.length - 1;
        int j = dp[i].length - 1;
        String superSeq = "";

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                superSeq = x.charAt(i - 1) + superSeq;
                i -= 1;
                j -= 1;
            } else {

                if (dp[i][j - 1] > dp[i - 1][j]) { // if left is max.move left
                    superSeq = y.charAt(j - 1) + superSeq;
                    j--;
                } else {
                    superSeq = x.charAt(i - 1) + superSeq;
                    i--;
                }
            }
        }

        while (i > 0) {
            superSeq = x.charAt(i - 1) + superSeq;
            i--;

        }

        while (j > 0) {
            superSeq = y.charAt(j - 1) + superSeq;
            j--;
        }

        return superSeq;
    }

    private int[][] lcsMatrix(String x, String y, int m, int n) {
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
        return dp;
    }

    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";

        String i = new ShortestCommonSuperSequence().superSequence(text1, text2);
        System.out.println(i);
    }
}

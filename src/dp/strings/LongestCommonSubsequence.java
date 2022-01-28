package dp.strings;

public class LongestCommonSubsequence {
    int[][] lookup = new int[1001][1001];

    public int lcs(String x, String y, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (x.charAt(n - 1) == y.charAt(m - 1))
            return 1 + lcs(x, y, n - 1, m - 1);
        else
            return
                    Math.max(
                            lcs(x, y, n, m - 1),
                            lcs(x, y, n - 1, m)
                    );
    }


    public int longestCommonSubsequence(String text1, String text2) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++)
                lookup[i][j] = -1;
        }

        return lcsMem(text1, text2, text1.length(), text2.length());
    }

    public int lcsMem(String x, String y, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (lookup[m][n] != -1)
            return lookup[m][n];

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            lookup[m][n] = 1 + lcsMem(x, y, n - 1, m - 1);
            return lookup[m][n];
        } else
            lookup[m][n] =
                    Math.max(
                            lcsMem(x, y, n, m - 1),
                            lcsMem(x, y, n - 1, m)
                    );
        return lookup[m][n];
    }
}

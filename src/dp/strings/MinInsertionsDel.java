package dp.strings;

public class MinInsertionsDel {
    public int minInsertionsDeletions(String x, String y) {
        int lcs = new LongestCommonSubsequence().lcsTabl(x, y, x.length(), y.length());

        return
                x.length() - lcs +
                        y.length() - lcs;

    }

    public static void main(String[] args) {
        int steps = new MinInsertionsDel().minInsertionsDeletions("heap", "pea");
        System.out.println(steps);
    }
}

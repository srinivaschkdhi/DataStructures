package dp.strings;

public class SubsequenceMatch {
    public boolean isSubsequence(String a, String b) {
        int lenOfLCS = new LongestCommonSubsequence().
                lcs(a, b, a.length(), b.length());

        return lenOfLCS == a.length();
    }

    public static void main(String[] args) {
        String a = "adf";
        String b = "abcdef";

        boolean ans = new SubsequenceMatch().isSubsequence(a, b);
        System.out.println(ans);
    }
}

package dp.strings;

public class LongestPalindromeSubsequence {
    public int maxLenPalindromeSub(String input){
        int n = input.length();

        return
                new LongestCommonSubsequence().
                        lcsTabl(input,reverse(input),n,n);
    }

    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "agbcba";
        int ans = new LongestPalindromeSubsequence().maxLenPalindromeSub(input);
        System.out.println(ans);
    }
}

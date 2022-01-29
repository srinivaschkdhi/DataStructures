package dp.strings;

public class MinDeletionsToPalindrome {
    public int minDeltoPalindrome(String input) {
        int palindromeSubsequenceLen = new LongestPalindromeSubsequence()
                .maxLenPalindromeSub(input);

        return input.length() - palindromeSubsequenceLen;

    }

    public static void main(String[] args) {
        String input = "agbcba";
        int ans = new MinDeletionsToPalindrome().minDeltoPalindrome(input);
        System.out.println(ans);
    }
}

// minimum no insertions to make palindrome === minimum no of deletions to make it palindrome
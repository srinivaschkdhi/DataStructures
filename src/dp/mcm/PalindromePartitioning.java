package dp.mcm;

public class PalindromePartitioning {

    public int minPartiions(String s) {
        return solve(s, 0, s.length() - 1);
    }

    public int solve(String s, int i, int j) {
        if (i >= j)
            return 0;

        if (isPalindrome(s, i, j))
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int temp = solve(s, i, k) + solve(s, k + 1, j) + 1;

            min = Math.min(min, temp);
        }

        return min;
    }

    private boolean isPalindrome(String s, int i, int j) {
        int aPointer = i;
        int bPointer = j;

        while (aPointer <= bPointer) {
            if (s.charAt(aPointer) != s.charAt(bPointer)) {
                return false;
            }

            aPointer += 1;
            bPointer -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        int ans = new PalindromePartitioning().minPartiions("ababbbabbababa");
        System.out.println(ans);

        boolean nitin = new PalindromePartitioning().isPalindrome("nitin", 0, 0);
        System.out.println("nitin = " + nitin);
    }
}

/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class LadderTab {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        int ans = numWaysToReachNthStep(n, k);
        System.out.println("ans = " + ans);
    }

    private static int numWaysToReachNthStep(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0)
                    dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

}

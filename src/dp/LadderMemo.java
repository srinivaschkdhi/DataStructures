/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class LadderMemo {
    static int[] lookup;

    static int ways(int n) {
        if (n < 0) return 0;
        if (lookup[n] == 0) {
            if (n == 0) return 1;
            int ans = ways(n - 1) + ways(n - 2) + ways(n - 3);
            return ans;
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        int n = 4;
        lookup = new int[n + 1];

        int ans = ways(n);
        System.out.println("ans = " + ans);
    }
}

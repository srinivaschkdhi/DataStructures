/**
 * @author Srinivas_Chintakindhi
 */

package dp.knapsacks;

public class LadderRecursion {
    static int ways(int n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        int ans = ways(n - 1) + ways(n - 2) + ways(n - 3);

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;

        int ans = ways(n);
        System.out.println("ways = " + ans);
    }
}

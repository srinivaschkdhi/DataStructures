/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class KnapsackRecur {
    public int knapsack(int[] wts, int prices[], int N, int W) {
        if (N == 0 || W == 0)
            return 0;

        int inc = 0, exc = 0;

        if (wts[N - 1] <= W) {
            inc = prices[N - 1] + knapsack(wts, prices, N - 1, W - wts[N - 1]);
        }

        exc = 0 + knapsack(wts, prices, N - 1, W);

        return Math.max(inc, exc);
    }



    public static void main(String[] args) {
        int[] wts = {2,7,3,4};
        int[] prices = {5,20,20,10};
        int N = 4;
        int W = 11;
        int knapsack = new KnapsackRecur().knapsack(wts, prices, N, W);
        System.out.println("knapsack = " + knapsack);
    }
}

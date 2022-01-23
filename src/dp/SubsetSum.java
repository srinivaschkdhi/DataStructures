package dp;

import java.util.Arrays;

public class SubsetSum {
    public static boolean isSubsetSumRecursion(int n, int[] arr, int sum) {
        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        if (arr[n - 1] <= sum) {
            return
                    isSubsetSumRecursion(n - 1, arr, sum - arr[n - 1]) ||
                            isSubsetSumRecursion(n - 1, arr, sum);
        } else {
            return isSubsetSumRecursion(n - 1, arr, sum);
        }
    }

    public static boolean isSubSetSumTabl(int n, int[] arr, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (i == 0 || j == 0) {

                    if (i == 0)
                        dp[i][j] = false;
                    if (j == 0)
                        dp[i][j] = true;

                } else {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]] ||
                                  dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        boolean subsetSum = isSubSetSumTabl(n, arr, 30);
        System.out.println("subsetSum = " + subsetSum);
//
//
//        arr = new int[]{5, 1, 1, 4, 6};
//        subsetSum = isSubSetSumTabl(5,arr,14);
//        System.out.println("subsetSum = " + subsetSum);

        boolean[][] matri = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (i == 0)
                    matri[i][j] = false;

                if (j == 0)
                    matri[i][j] = true;

                if (i != 0 && j != 0) {

                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matri[i][j] + " ");
            }
            System.out.println();
        }
    }
}

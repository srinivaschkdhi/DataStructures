package dp.mcm;

public class MatrixChainMultiplication {
    static int[][] dp = new int[1001][1001];

    public static int minimumCost(int[] dimensions) {
        int i = 1;
        int j = dimensions.length - 1;

        for (int i1 = 0; i1 < dp.length; i1++) {
            for (int i2 = 0; i2 < dp[i1].length; i2++) {
                dp[i1][i2] = -1;
            }
        }

        return solveMemo(dimensions, i, j);
    }

    public static int solve(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int temp = solve(arr, i, k)
                    +
                    solve(arr, k + 1, j)
                    +
                    arr[i - 1] * arr[k] * arr[j];

            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public static int solveMemo(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;

        if(dp[i][j] != -1)
            return dp[i][j];

        for (int k = i; k <= j - 1; k++) {

            dp[i][j] = solve(arr, i, k)
                    +
                    solve(arr, k + 1, j)
                    +
                    arr[i - 1] * arr[k] * arr[j];

            if (dp[i][j] < min) {
                min = dp[i][j];
            }
        }

        return min;
    }


    public static void main(String[] args) {
        int[] dimensions = {10, 20, 30};
        int cost = minimumCost(dimensions);
        System.out.println(cost);
    }
}

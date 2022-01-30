package dp.knapsacks;

public class MinimumDiffSubsetsSum {
    public static int minDiffSubsetsSum(int[] arr) {
        int range = getRange(arr);

        boolean[][] dp = isSubSetSumTabl(arr.length, arr, range);

        int lastRow = dp.length - 1;
        int lastCol = dp[0].length / 2;

        int min = Integer.MAX_VALUE;

        for (int col = 0; col < lastCol; col++) {
            if (dp[lastRow][col] == true)
                min = Math.min(min, range - (2 * col));
        }

        return min;
    }

    private static boolean[][] isSubSetSumTabl(int n, int[] arr, int sum) {
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
        //print matrix
        printMatrix(dp);
        return dp;
    }

    private static void printMatrix(boolean[][] dp) {
        for (boolean[] arr : dp) {
            for (boolean b : arr) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    private static int getRange(int[] arr) {
        int range = 0;

        for (int i : arr) {
            range += i;
        }

        return range;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] arr = {5, 6, 6, 5, 7, 4, 7, 6};

        int ans = minDiffSubsetsSum(arr);
        System.out.println(ans);
    }
}

// s1 + s2 = range
// s2 = range - s1

// s2 - s1 = min

// range - s1- s1 = min
// range - 2s1 = min

// min = range - 2s1

// s1 lies b/w 0 and range
// s1 lies b/w 0 ang range/2 (to get min diff b/w sums)
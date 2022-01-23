package bits;

public class CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = dp[i / 2];
            }
        }

        return dp;
    }

    public int[] countBits2(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;


        for (int i = 1; i <= n; i++) {
            int count = 0;
            int num = i;

            while (num > 0) {
                count += (num & 1);
                num = num >> 1;
            }
            arr[i] = count;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] countBits = new CountingBits().countBits(5);
        for (int i :
                countBits) {
            System.out.println(i);
        }
    }
}

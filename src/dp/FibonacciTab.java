/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class FibonacciTab {
    public static void main(String[] args) {
        int n = 6;
        int fib = fib(n);
        System.out.println("fib = " + fib);
    }

    public static int fib(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}

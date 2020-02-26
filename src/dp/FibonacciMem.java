/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class FibonacciMem {
    static int[] lookup;

    public static void main(String[] args) {
        int n = 6;
        lookup = new int[n + 1];

        int fib = fib(n);
        System.out.println("fib = " + fib);
    }

    public static int fib(int n) {
        if (lookup[n] == 0) {
            if (n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fib(n - 1) + fib(n - 2);
        }
        return lookup[n];
    }
}

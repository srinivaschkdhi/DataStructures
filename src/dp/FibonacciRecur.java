/**
 * @author Srinivas_Chintakindhi
 */

package dp;

public class FibonacciRecur {
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        int f1 = fibonacci(n - 1);
        int f2 = fibonacci(n - 2);
        int f = f1 + f2;
        return f;
    }

    public static void main(String[] args) {
        int fibonacci = fibonacci(2);
        System.out.println("fibonacci = " + fibonacci);
    }
}

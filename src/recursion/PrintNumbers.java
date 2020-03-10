/**
 * @author Srinivas_Chintakindhi
 */

package recursion;

import java.text.ParseException;

public class PrintNumbers {
    public static void decreasingPrint(int n) {
        if (n == 0)
            return;

        decreasingPrint(n - 1);
        System.out.println(n);
    }

    public static void increasingPrint(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        increasingPrint(n - 1);

    }

    public static void main(String[] args) throws ParseException {
        System.out.println("Decreasing order");
        decreasingPrint(5);
        System.out.println("Increasing Order");
        increasingPrint(5);
    }
}

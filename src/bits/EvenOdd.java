/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class EvenOdd {
    public static void main(String[] args) {
        int n = 4;

        if( (n & 1) == 0)
            System.out.println("even");
        else
            System.out.println("odd");
    }
}

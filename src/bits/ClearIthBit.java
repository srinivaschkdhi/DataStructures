/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class ClearIthBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        int mask = ~(1 << i);

        n = n & mask;

        System.out.println("n = " + n);
    }
}

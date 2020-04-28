/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class SetIthBit {
    public static void main(String[] args) {
        int n  = 13;
        int i = 1;

        n = (n | (1 << i));

        System.out.println("n = " + n);
    }
}

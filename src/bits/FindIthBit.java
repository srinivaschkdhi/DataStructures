/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class FindIthBit {
    public int getIthBit(int n, int i) {
        if ((n & (1 << i)) == 0)
            return 0;
        else
            return 1;
    }

    public static void main(String[] args) {
        int ithBit = new FindIthBit().getIthBit(13, 2);
        System.out.println("ithBit = " + ithBit);
    }
}

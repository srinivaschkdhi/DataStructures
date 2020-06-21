/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class CountSetBits {
    public int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }

    public int countSetBitsFast(int n){
        int count = 0;

        while(n > 0){
            count += 1;
            n = n & (n - 1); // removes last set bit
        }

        return count;
    }
    public static void main(String[] args) {
        int bits = new CountSetBits().countSetBits(13);
        System.out.println("bits = " + bits);

        bits = new CountSetBits().countSetBitsFast(13);
        System.out.println("bits = " + bits);
    }
}

/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class FindTwoUniqueNumbers {

    public void findUnique2(int[] arr) {
        int xorRes = 0;

        for (int x : arr) {
            xorRes ^= x;
        }

        int i = getRightMostSetBitPos(xorRes);

        int mask = 1 << i;

        int firstNum = 0;

        for (int j = 0; j < arr.length; j++) {
            if ((arr[j] & mask) == 1) { // if num has set bit at i positon xor with firstnum
                firstNum ^= arr[j];
            }
        }

        int secondNum = firstNum ^ xorRes;

        System.out.println("firstNum = " + firstNum);
        System.out.println("secondNum = " + secondNum);
    }

    private int getRightMostSetBitPos(int xorRes) {
        int i = 0;
        int n = xorRes;

        while (n > 0) {
            if ((n & 1) == 1)
                break;

            i++;
            n = n >> 1;
        }
        return i;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 3, 2, 1, 2};

        new FindTwoUniqueNumbers().findUnique2(arr);

    }
}

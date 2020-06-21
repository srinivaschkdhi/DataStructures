/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class Subsets {


    public void generateSubsets(String s){
        int n = s.length();
        int range = (1 << n) -1; // if n = 3. range = 7 i.e 1 1 1. thats'y range = 2^n - 1
                                // range means last value. with 3 bits 7 is biggest num we can represent.
                                // range is 0 to 7 (total 8 ways).

        for (int i = 0; i <=range; i++) {
            filterChars(s,i);
        }
    }


    public void filterChars(String s,int n){
        int i = 0;


        while(n > 0){
            if((n & 1)==1)
                System.out.print(s.charAt(i));

            i++;
            n = n >> 1;
        }

        System.out.println();
    }
    public static void main(String[] args) {
        String s  = "abc";
        new Subsets().generateSubsets(s);
    }
}

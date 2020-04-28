/**
 * @author Srinivas_Chintakindhi
 */

package bits;

public class Subsets {


    public void generateSubsets(String s){
        int n = s.length();
        int range = (1 << n) -1;

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

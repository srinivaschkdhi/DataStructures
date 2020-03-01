/**
 * @author Srinivas_Chintakindhi
 */

package recursion;

public class Factorial {
    public static int fact(int n){
        if(n == 0) return 1;

        int smallFact = fact(n -1);
        int ans = smallFact * n;
        return ans;
    }

    public static void main(String[] args) {
        int fact = fact(3);
        System.out.println("fact = " + fact);
    }
}

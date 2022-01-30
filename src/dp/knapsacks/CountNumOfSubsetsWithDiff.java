package dp.knapsacks;

public class CountNumOfSubsetsWithDiff {
    public static int countNumOfSubsetsDiff(int[] arr, int diff) {
        int sum = getSum(arr);
        int s1 = (sum + diff) / 2;

        return countNumOfSubsetsDiff(arr, s1);
    }

    private static int getSum(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
// s1 - subset sum one
// s2 subset sum two

// s1 - s2 = diff
// s1 - s2 = sum(arr)
// add both equations

//2s1 = sum(arr) + diff
//s1 = (sum(arr) + diff)  / 2
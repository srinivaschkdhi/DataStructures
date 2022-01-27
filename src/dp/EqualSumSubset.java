package dp;

public class EqualSumSubset {
    public boolean isEqualSumPartition(int[] arr, int n) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 == 1)
            return false;

        return subsetSum(arr, sum / 2);
    }

    private boolean subsetSum(int[] arr, int sum) {
        return SubsetSum.isSubSetSumTabl(arr.length, arr, sum);
    }
}

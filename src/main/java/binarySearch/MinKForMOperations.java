package binarySearch;

/*
Given an array A of integers and an integer m, we can perform following operation on the array-
Choose an index i and change A[i] to max(0, A[i]-k).
Find the minimum value of k such that each element is changed to 0 and number of operations are at most m.
http://thejoboverflow.com/p/p647/ (Question 1)
 */
public class MinKForMOperations {
    public int solve(int[] A, int m) {
        int max = Integer.MIN_VALUE;
        for (int element : A) {
            max = Math.max(max, element);
        }

        int low = 0, high = max;

        while (high > low) {
            int mid = low + (high - low) / 2;
            if (canReduceToZero(A, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canReduceToZero(int[] arr, int num, int maxOpsAllowed) {
        if (num == 0)
            return false;

        int operations = 0;
        for (int element : arr) {
            if (element == 0)
                continue;
            operations += Math.ceil(element / num);
        }
        return operations <= maxOpsAllowed;
    }
}

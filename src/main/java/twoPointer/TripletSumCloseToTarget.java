package twoPointer;

import java.util.Arrays;

// Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the
// target number as possible, return the sum of the triplet.
public class TripletSumCloseToTarget {
    public int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int low = i + 1;
            int high = arr.length - 1;
            while (low < high) {
                int sum = arr[low] + arr[high] + arr[i];
                if (sum == targetSum) {
                    return sum;
                }
                if (Math.abs(targetSum - sum) < Math.abs(minDiff))
                    minDiff = targetSum - sum;

                if (sum < targetSum)
                    low++;
                else
                    high--;
            }
        }
        return targetSum - minDiff;
    }
}

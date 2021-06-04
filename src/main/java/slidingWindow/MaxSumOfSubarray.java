package slidingWindow;
// Important
// Find the maximum sum possible from a subarray of size k
public class MaxSumOfSubarray {
    int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE, sum = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum-=arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}

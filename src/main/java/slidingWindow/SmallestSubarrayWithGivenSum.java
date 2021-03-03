package slidingWindow;

// Find the length of the smallest subarray with sum >= s
public class SmallestSubarrayWithGivenSum {
    int findMinSubArrayLength(int s, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE, windowStart = 0, sum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            while (sum >= s) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                sum -= arr[windowStart++];
            }
        }

        return minWindowSize;
    }
}

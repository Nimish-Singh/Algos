package slidingWindow;

// Find the length of the smallest subarray with sum >= s
public class SmallestSubarrayWithGivenSum {
    int findMinSubArrayLength(int s, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE, windowStart = 0, sum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            while (windowEnd < arr.length && sum + arr[windowEnd] < s) {
                sum += arr[windowEnd++];
            }
            if (windowEnd < arr.length)
                sum += arr[windowEnd];

            while (windowStart <= windowEnd && sum - arr[windowStart] >= s) {
                sum -= arr[windowStart++];
            }
            minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
        }

        return minWindowSize;
    }
}

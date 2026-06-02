package slidingWindow;

public class MaxSumNonOverlappingArrays {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        if (nums == null)
            return 0;
        int maxSum = 0;

        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        for (int i = 0; i <= nums.length - firstLen; i++) {

            int sum1 = prefix[i + firstLen] - prefix[i];

            for (int j = 0; j <= nums.length - secondLen; j++) {
                int sum2 = prefix[j + secondLen] - prefix[j];

                if (i + firstLen <= j || j + secondLen <= i) { // => there is no overlap
                    maxSum = Math.max(maxSum, sum1 + sum2);
                }
            }
        }

        return maxSum;
    }
}

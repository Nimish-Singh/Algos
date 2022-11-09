package slidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxOnes {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

//        return myApproach(nums, k);

        return sameLogicButCleaner(nums, k);
    }

    private int sameLogicButCleaner(int[] nums, int k) {
        int zeroCount = 0, windowStart = 0, maxLength = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[windowStart] == 0)
                    zeroCount--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    private int myApproach(int[] nums, int k) {
        int windowStart = 0, windowEnd = 0, numZeroes = 0, maxLength = Integer.MIN_VALUE;
        for (windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0)
                numZeroes++;

            if (numZeroes == k + 1) {
                windowEnd--;
                numZeroes--;
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

                while (windowStart < nums.length - 1 && nums[windowStart] == 1)
                    windowStart++;
                windowStart++;
                numZeroes--;
            }
        }
        return Math.max(maxLength, windowEnd - windowStart);
    }
}

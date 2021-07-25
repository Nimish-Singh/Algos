package leetcode;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinSubarraySumSize {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1 && nums[0] > target)
            return 1;

        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];

            while (sum - nums[windowStart] >= target)
                sum -= nums[windowStart++];

            if (sum >= target)
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

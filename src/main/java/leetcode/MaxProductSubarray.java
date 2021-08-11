package leetcode;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0], min = nums[0], result = nums[0];

        for (int index = 1; index < nums.length; index++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[index], min * nums[index]), nums[index]);
            min = Math.min(Math.min(temp * nums[index], min * nums[index]), nums[index]);

            result = Math.max(result, max);
        }

        return result;
    }
}

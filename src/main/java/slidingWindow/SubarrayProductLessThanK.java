package slidingWindow;

// https://leetcode.com/problems/subarray-product-less-than-k
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int start = 0, total = 0;
        int product = 1;

        for (int end = 0; end < nums.length; end++) {
            product *= nums[end];

            while (product >= k) {
                product /= nums[start];
                start++;
            }
            total += end - start + 1;
        }

        return total;
    }
}

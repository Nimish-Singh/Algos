package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/count-the-number-of-fair-pairs/description/
public class FairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countLessThan(nums, upper) - countLessThan(nums, lower - 1);
    }

    private long countLessThan(int[] nums, int sumUpperBound) {
        int low = 0, high = nums.length - 1;
        long count = 0;

        while (low < high) {
            if (nums[low] + nums[high] <= sumUpperBound) {
                // If left and right have sum smaller than target,
                // means all elements from l+1 to r form a pair with l
                // say we have found the subarray [2,3,4,5] and target is 7
                // (2,3), (2,4), (2,5) are pairs with sum <= 7
                count += high - low;
                low++;
            } else {
                high--;
            }
        }
        return count;
    }
}

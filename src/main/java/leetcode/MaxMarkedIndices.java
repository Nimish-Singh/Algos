package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-maximum-number-of-marked-indices/
public class MaxMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int i = 0, count = 0;
        for (int j = nums.length - nums.length / 2; j < nums.length; j++) {
            if (2 * nums[i] <= nums[j]) {
                count += 2;
                i++;
            }
        }
        return count;
    }
}

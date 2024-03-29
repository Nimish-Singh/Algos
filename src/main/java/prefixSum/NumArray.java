package prefixSum;

// https://leetcode.com/problems/range-sum-query-immutable/
public class NumArray {
    private int[] prefixSumArray;

    public NumArray(int[] nums) {
        prefixSumArray = new int[nums.length];

        prefixSumArray[0] = nums[0];
        for (int index = 1; index < prefixSumArray.length; index++) {
            prefixSumArray[index] = prefixSumArray[index - 1] + nums[index];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSumArray[right];
        }

        return prefixSumArray[right] - prefixSumArray[left - 1];
    }
}

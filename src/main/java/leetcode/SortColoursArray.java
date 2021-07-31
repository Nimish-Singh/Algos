package leetcode;

// https://leetcode.com/problems/sort-colors/
public class SortColoursArray {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;

        int zeroIndex = 0, twoIndex = nums.length - 1;

        for (int index = 0; index <= twoIndex; index++) {
            if (nums[index] == 0) {
                nums[index] = nums[zeroIndex];
                nums[zeroIndex++] = 0;
                continue;
            }

            if (nums[index] == 2) {
                nums[index] = nums[twoIndex];
                nums[twoIndex--] = 2;
                index--;
            }
        }
    }
}

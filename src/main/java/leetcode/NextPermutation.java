package leetcode;

// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;

        while (index > 0 && nums[index] <= nums[index - 1])
            --index;

        if (index == 0) {
            swapElementsInRange(nums, 0, nums.length - 1);
        } else {
            int j = nums.length - 1;
            while (j >= index && nums[j] <= nums[index - 1])
                --j;

            int temp = nums[j];
            nums[j] = nums[index - 1];
            nums[index - 1] = temp;

            swapElementsInRange(nums, index, nums.length - 1);

        }
    }

    private void swapElementsInRange(int[] nums, int startIndex, int endIndex) {
        for (int i = startIndex; i <= (endIndex + startIndex) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[startIndex + endIndex - i];
            nums[startIndex + endIndex - i] = temp;
        }
    }
}

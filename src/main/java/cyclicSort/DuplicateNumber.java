package cyclicSort;

// Given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’, which has only one duplicate
// (can be repeated multiple times), find that duplicate number without using any extra space
public class DuplicateNumber {
    public int duplicateNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swapForIndices(nums, i, nums[i] - 1);
                } else
                    return nums[i];
            } else
                ++i;
        }
        return -1;
    }

    private void swapForIndices(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

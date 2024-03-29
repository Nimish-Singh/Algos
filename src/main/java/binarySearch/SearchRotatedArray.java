package binarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low - low / 2 + high / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
                continue;
            }

            if (nums[mid] < target && target <= nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}

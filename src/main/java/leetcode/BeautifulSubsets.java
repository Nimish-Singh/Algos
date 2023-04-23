package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/the-number-of-beautiful-subsets/description/
public class BeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> seen = new HashMap<>();

        // subtracting 1 for the empty subset
        return dfs(nums, k, seen, nums.length, 0) - 1;
    }

    private int dfs(int[] nums, int k, Map<Integer, Integer> seen, int totalSize, int index) {
        if (index == totalSize) {
            return 1;
        }

        int result = 0;
        if (seen.getOrDefault(nums[index] - k, 0) == 0) {
            seen.put(nums[index], seen.getOrDefault(nums[index], 0) + 1);
            result += dfs(nums, k, seen, totalSize, index + 1);
            seen.put(nums[index], seen.get(nums[index]) - 1);
        }
        result += dfs(nums, k, seen, totalSize, index + 1);
        return result;
    }
}

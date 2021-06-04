package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class TripletSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            findPairs(nums, nums[i], i, result);

            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                ++i;

        }
        return result;
    }

    private void findPairs(int[] nums, int num, int i, List<List<Integer>> result) {
        int j = i + 1, k = nums.length - 1;

        while (j < k) {
            if (num + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(num, nums[j], nums[k]));
                ++j;
                --k;
                while (j < k && nums[j] == nums[j - 1])
                    ++j;
                while (j < k && nums[k] == nums[k + 1])
                    --k;
                continue;
            } else if (num + nums[j] + nums[k] < 0)
                ++j;
            else
                --k;
        }
    }
}

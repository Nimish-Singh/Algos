package blind75.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
//        return spaceOptimised(nums);
        return timeOptimised(nums);
    }

    public boolean timeOptimised(int[] nums) {
        if (nums.length < 2)
            return false;

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }

    public boolean spaceOptimised(int[] nums) {
        if (nums.length < 2)
            return false;

        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] == nums[index + 1])
                return true;
        }
        return false;
    }
}

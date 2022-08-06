package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
//        return inefficient(nums, k);

        return efficient(nums, k);
    }

    private int efficient(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (sumCountMap.containsKey(sum - k))
                count += sumCountMap.get(sum - k);

            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    private int inefficient(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int index = 1; index < sum.length; index++) {
            // sum(i) = sum of numbers until nums(i-1)
            sum[index] = sum[index - 1] + nums[index - 1];
        }

        for (int start = 0; start < sum.length; start++) {
            for (int end = start + 1; end < sum.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }

        return count;
    }
}

package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/description/
public class MaximisePrefixScore {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);

        long runningSum = 0;
        int answer = 0;
        for (int index = nums.length - 1; index >= 0; index--) {
            runningSum += nums[index];
            if (runningSum <= 0)
                break;
            answer++;
        }
        return answer;
    }
}

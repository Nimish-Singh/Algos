package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// Important
// https://leetcode.com/problems/longest-arithmetic-subsequence/description/
public class LongestArithmeticSubsequenceAnyDiff {
    // https://leetcode.com/problems/longest-arithmetic-subsequence/editorial/
    public int longestArithSeqLength(int[] nums) {
        int answer = 0;
        Map<Integer, Integer>[] memo = new HashMap[nums.length];

        for (int right = 0; right < nums.length; right++) {
            memo[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int diff = nums[left] - nums[right];
                memo[right].put(diff, memo[left].getOrDefault(diff, 1) + 1);
                answer = Math.max(answer, memo[right].get(diff));
            }
        }
        return answer;
    }
}

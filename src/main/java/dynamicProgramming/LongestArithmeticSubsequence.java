package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
public class LongestArithmeticSubsequence {
    // https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/editorial/
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> memo = new HashMap<>();
        int answer = 1;
        for (int element : arr) {
            int subsequenceLengthForPreviousBeforeDiff = memo.getOrDefault(element - difference, 0);
            memo.put(element, subsequenceLengthForPreviousBeforeDiff + 1);
            answer = Math.max(answer, memo.get(element));
        }
        return answer;
    }
}

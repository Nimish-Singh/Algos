package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class MinInsertionsToMakePalindrome {

    // Find longest palindromic subsequence (lps). Answer is s.length() - lps.length()
    public int minInsertions(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);

        int lpsLength = longestPalindromicSubsequence(s, 0, s.length() - 1, memo);
        return s.length() - lpsLength;
    }

    private int longestPalindromicSubsequence(String string, int startIndex, int endIndex, int[][] memo) {
        if (string.length() == 0 || startIndex > endIndex)
            return 0;

        if (startIndex == endIndex)
            return 1;

        if (memo[startIndex][endIndex] != Integer.MIN_VALUE)
            return memo[startIndex][endIndex];

        if (string.charAt(startIndex) == string.charAt(endIndex)) {
            memo[startIndex][endIndex] = 2 + longestPalindromicSubsequence(string, startIndex + 1, endIndex - 1, memo);
            return memo[startIndex][endIndex];
        }

        memo[startIndex][endIndex] = Math.max(
            longestPalindromicSubsequence(string, startIndex + 1, endIndex, memo),
            longestPalindromicSubsequence(string, startIndex, endIndex - 1, memo)
        );

        return memo[startIndex][endIndex];
    }
}

package dynamicProgramming;

// Important
// https://leetcode.com/problems/longest-palindromic-subsequence
public class LongestPalindromicSubsequence {
    int findLength(String s) {
//        return recursive(s, 0, s.length() - 1);
        return topDown(s, 0, s.length() - 1, new int[s.length()][s.length()]);
//        return bottomUp(s);
    }

    // It's like finding the LCS (longest common subsequence) between s and reverse(s)
    private int bottomUp(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int length = s.length();
        int[][] lpsLength = new int[length][length];

        for (int start = length - 1; start >= 0; start--) {
            lpsLength[start][start] = 1;

            for (int end = start + 1; end < length; end++) {
                if (s.charAt(start) == s.charAt(end))
                    lpsLength[start][end] = 2 + lpsLength[start + 1][end - 1];
                else
                    lpsLength[start][end] = Math.max(lpsLength[start + 1][end], lpsLength[start][end - 1]);
            }
        }
        return lpsLength[0][length - 1];
    }

    private int topDown(String s, int start, int end, int[][] memo) {
        if (start > end)
            return 0;

        if (start == end)
            return 1;

        if (memo[start][end] != 0)
            return memo[start][end];

        if (s.charAt(start) == s.charAt(end)) {
            memo[start][end] = 2 + topDown(s, start + 1, end - 1, memo);
            return memo[start][end];
        }

        memo[start][end] = Math.max(topDown(s, start + 1, end, memo), topDown(s, start, end - 1, memo));
        return memo[start][end];
    }

    private int recursive(String s, int start, int end) {
        if (start > end)
            return 0;

        if (start == end)
            return 1;

        if (s.charAt(start) == s.charAt(end))
            return 2 + recursive(s, start + 1, end - 1);

        return Math.max(recursive(s, start + 1, end), recursive(s, start, end - 1));
    }
}

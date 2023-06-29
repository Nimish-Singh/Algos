package dynamicProgramming;

import java.util.Arrays;

// Important
// https://leetcode.com/problems/edit-distance
public class EditDistance {
    public int minOperations(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null) {
            return s2.length();
        }
        if (s2 == null) {
            return s1.length();
        }
//        return s1.length() > s2.length() ? minOperationsToChangeStringsRecursive(s2, s1) : minOperationsToChangeStringsRecursive(s1, s2);

//        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
//        for (int[] row : memo) Arrays.fill(row, -1);
//        return topDown(s1, s2, s1.length(), s2.length(), memo);

        return bottomUp(s1, s2);
//        return recursive(s1, s2);
    }

    private int recursive(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        if (word1.charAt(0) == word2.charAt(0)) {
            return recursive(word1.substring(1), word2.substring(1));
        }

        return 1 + Math.min(recursive(word1, word2.substring(1)), Math.min(
            recursive(word1.substring(1), word2),
            recursive(word1.substring(1), word2.substring(1))
        ));
    }

    private int topDown(String word1, String word2, int index1, int index2, int[][] memo) {
        if (index1 == 0) {
            memo[index1][index2] = index2;
            return memo[index1][index2];
        }
        if (index2 == 0) {
            memo[index1][index2] = index1;
            return memo[index1][index2];
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
            memo[index1][index2] = topDown(word1, word2, index1 - 1, index2 - 1, memo);
            return memo[index1][index2];
        }

        memo[index1][index2] = 1 + Math.min(topDown(word1, word2, index1, index2 - 1, memo), Math.min(
            topDown(word1, word2, index1 - 1, index2, memo),
            topDown(word1, word2, index1 - 1, index2 - 1, memo)
        ));
        return memo[index1][index2];
    }

    private int bottomUp(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        for (int index1 = 0; index1 <= s1.length(); index1++) {
            for (int index2 = 0; index2 <= s2.length(); index2++) {
                if (index1 == 0)
                    memo[index1][index2] = index2;
                else if (index2 == 0)
                    memo[index1][index2] = index1;
                else if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    memo[index1][index2] = memo[index1 - 1][index2 - 1];
                else
                    memo[index1][index2] = 1 + Math.min(memo[index1 - 1][index2 - 1], Math.min(
                        memo[index1][index2 - 1], memo[index1 - 1][index2]
                    ));
            }
        }

        return memo[s1.length()][s2.length()];
    }
}

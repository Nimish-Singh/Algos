package dynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    int findLength(String string) {
        int[][] lpsLengthTable = new int[string.length()][string.length()];
        for (int[] rows : lpsLengthTable)
            Arrays.fill(rows, Integer.MIN_VALUE);
        return findLengthTopDown(string, 0, string.length() - 1, lpsLengthTable);
    }

    private int findLengthTopDown(String string, int startIndex, int endIndex, int[][] lpsLengthTable) {
        if (string.length() == 0 || startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }

        if (lpsLengthTable[startIndex][endIndex] != Integer.MIN_VALUE) {
            return lpsLengthTable[startIndex][endIndex];
        }

        if (string.charAt(startIndex) == string.charAt(endIndex)) {
            lpsLengthTable[startIndex][endIndex] = 2 + findLengthTopDown(string, startIndex + 1, endIndex - 1, lpsLengthTable);
            return lpsLengthTable[startIndex][endIndex];
        }

        lpsLengthTable[startIndex][endIndex] = Math.max(
                findLengthTopDown(string, startIndex + 1, endIndex, lpsLengthTable),
                findLengthTopDown(string, startIndex, endIndex - 1, lpsLengthTable)
        );
        return lpsLengthTable[startIndex][endIndex];
    }
}

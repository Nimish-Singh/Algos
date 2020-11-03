package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    int findLength(String string1, String string2) {
        int[][] lengthsTable = new int[string1.length()][string2.length()];
        for (int[] array : lengthsTable)
            Arrays.fill(array, Integer.MIN_VALUE);
        return findLengthTopDown(string1, string1.length(), string2, string2.length(), lengthsTable);
    }

    private int findLengthTopDown(String s1, int s1Index, String s2, int s2Index, int[][] lengthsTable) {
        if (s1Index == 0 || s2Index == 0) {
            return 0;
        }
        if (lengthsTable[s1Index - 1][s2Index - 1] != Integer.MIN_VALUE) {
            return lengthsTable[s1Index - 1][s2Index - 1];
        }
        if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1)) {
            lengthsTable[s1Index - 1][s2Index - 1] = 1 + findLengthTopDown(s1, s1Index - 1, s2, s2Index - 1, lengthsTable);
            return lengthsTable[s1Index - 1][s2Index - 1];
        }
        lengthsTable[s1Index - 1][s2Index - 1] = Math.max(
                findLengthTopDown(s1, s1Index - 1, s2, s2Index, lengthsTable),
                findLengthTopDown(s1, s1Index, s2, s2Index - 1, lengthsTable)
        );
        return lengthsTable[s1Index - 1][s2Index - 1];
    }
}

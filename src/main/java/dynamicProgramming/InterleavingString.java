package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
//        return recursiveApproach(s1, 0, s2, 0, s3, 0);

        int[][] memo = new int[s1.length()][s2.length()];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return topDown(s1, 0, s2, 0, s3, 0, memo);
    }

    // T=O(mn). S=O(mn)
    private boolean topDown(String firstInput, int firstIndex, String secondInput, int secondIndex, String expectedResult, int resultIndex, int[][] memo) {
        if (firstIndex == firstInput.length())
            return secondInput.substring(secondIndex).equals(expectedResult.substring(resultIndex));

        if (secondIndex == secondInput.length())
            return firstInput.substring(firstIndex).equals(expectedResult.substring(resultIndex));

        if (memo[firstIndex][secondIndex] != -1)
            return memo[firstIndex][secondIndex] == 1 ? true : false;

        boolean isInterleaved = false;

        if (firstInput.charAt(firstIndex) == expectedResult.charAt(resultIndex))
            isInterleaved = isInterleaved || topDown(firstInput, firstIndex + 1, secondInput, secondIndex, expectedResult, resultIndex + 1, memo);

        if (secondInput.charAt(secondIndex) == expectedResult.charAt(resultIndex))
            isInterleaved = isInterleaved || topDown(firstInput, firstIndex, secondInput, secondIndex + 1, expectedResult, resultIndex + 1, memo);

        memo[firstIndex][secondIndex] = isInterleaved ? 1 : 0;

        return isInterleaved;
    }

    // T=O(2^{m+n}) S=O(s^{m+n}) [recursion stack]
    private boolean recursiveApproach(String firstInput, int firstIndex, String secondInput, int secondIndex, String expectedResult, int resultIndex) {
        if (firstIndex == firstInput.length() && secondIndex == secondInput.length() && resultIndex == expectedResult.length())
            return true;

        boolean isInterleave = false;

        if (firstIndex < firstInput.length() && firstInput.charAt(firstIndex) == expectedResult.charAt(resultIndex)) {
            isInterleave = isInterleave || recursiveApproach(firstInput, firstIndex + 1, secondInput, secondIndex, expectedResult, resultIndex + 1);
        }
        if (secondIndex < secondInput.length() && secondInput.charAt(secondIndex) == expectedResult.charAt(resultIndex)) {
            isInterleave = isInterleave || recursiveApproach(firstInput, firstIndex, secondInput, secondIndex + 1, expectedResult, resultIndex + 1);
        }

        return isInterleave;
    }
}

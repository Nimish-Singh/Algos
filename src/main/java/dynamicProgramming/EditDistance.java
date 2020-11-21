package dynamicProgramming;

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
//        return minOperationsToChangeStringsTopDown(s1, s2, s1.length(), s2.length(), memo);

        return minOperationsToChangeStringsBottomUp(s1, s2);
    }

    private int minOperationsToChangeStringsRecursive(String changeFrom, String changeTo) {

        if (changeFrom.length() == 0) {
            return changeTo.length();
        }
        if (changeTo.length() == 0) {
            return changeFrom.length();
        }

        if (changeFrom.charAt(0) == changeTo.charAt(0)) {
            return minOperations(changeFrom.substring(1), changeTo.substring(1));
        }

        if (changeTo.length() == 1) {
            return 1;
        }

        if (changeFrom.charAt(0) == changeTo.charAt(1)) {
            return 1 + minOperations(changeFrom.substring(1), changeTo.substring(2));
        }

        return 1 + Math.min(
                minOperations(changeFrom.substring(1), changeTo.substring(1)),
                minOperations(changeFrom, changeTo.substring(1))
        );
    }

    private int minOperationsToChangeStringsTopDown(String s1, String s2, int s1Index, int s2Index, int[][] memo) {
        if (memo[s1Index][s2Index] != -1) {
            return memo[s1Index][s2Index];
        }
        if (s1Index == 0) {
            memo[s1Index][s2Index] = s2Index;
            return memo[s1Index][s2Index];
        }
        if (s2Index == 0) {
            memo[s1Index][s2Index] = s1Index;
            return memo[s1Index][s2Index];
        }

        if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1)) {
            memo[s1Index][s2Index] = minOperationsToChangeStringsTopDown(s1, s2, s1Index - 1, s2Index - 1, memo);
            return memo[s1Index][s2Index];
        }

        memo[s1Index][s2Index] = 1 + Math.min(
                minOperationsToChangeStringsTopDown(s1, s2, s1Index, s2Index - 1, memo),
                Math.min(minOperationsToChangeStringsTopDown(s1, s2, s1Index - 1, s2Index, memo),
                        minOperationsToChangeStringsTopDown(s1, s2, s1Index - 1, s2Index - 1, memo))
        );
        return memo[s1Index][s2Index];
    }

    private int minOperationsToChangeStringsBottomUp(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    memo[i][j] = j;
                else if (j == 0)
                    memo[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    memo[i][j] = memo[i - 1][j - 1];
                else
                    memo[i][j] = 1 + Math.min(
                            memo[i][j - 1], Math.min(
                                    memo[i - 1][j], memo[i - 1][j - 1]));
            }
        }
        return memo[s1.length()][s2.length()];
    }
}

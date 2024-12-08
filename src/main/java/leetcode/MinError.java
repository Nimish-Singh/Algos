package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

// There is a binary string with "0", "1" and "!", where "!" represents an unknown character which can be
// replaced with either "0" or "1". Errors (represented by "1") are generated every time characters "0" and "1"
// appear together as "01" or "10" in any subscequence of the string. The number of errors a subsequence "01"
// generates is x, while a subsequence "10" generates y errors. Return the minimum total errors generated,
// module 10^9 + 7.
public class MinError {
    private final int MODULO = 1_000_000_007;

    public int minErrors(String errorString, int x, int y){
        x = x % MODULO;
        y = y % MODULO;

        int errorAfterReplacingWith0 = findError(errorString, x, y, '0');
        int errorAfterReplacingWith1 = findError(errorString, x, y, '1');

        return Math.min(errorAfterReplacingWith0, errorAfterReplacingWith1);
    }

    private int findError(String errorString, int x, int y, char replacement) {
        char[] errorStringArr = errorString.toCharArray();

        for (int index = 0; index < errorStringArr.length; index++)
            if (errorStringArr[index] == '!')
                errorStringArr[index] = replacement;

        int[][] memo = new int[errorString.length()][2];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        int errorsX = findSubCount(new String(errorStringArr), "01", 0, 0, memo);

        for (int[] row : memo)
            Arrays.fill(row, -1);

        int errorsY = findSubCount(new String(errorStringArr), "10", 0, 0, memo);

        return (BigInteger.valueOf(errorsX).multiply(BigInteger.valueOf(x)).mod(BigInteger.valueOf(MODULO))
                .add(BigInteger.valueOf(errorsY).multiply(BigInteger.valueOf(y)).mod(BigInteger.valueOf(MODULO))))
                .mod(BigInteger.valueOf(MODULO))
                .intValue();
    }

    private int findSubCount(String str, String subsequence, int strIndex, int subIndex, int[][] memo) {
        if (subIndex >= subsequence.length())
            return 1;

        if (strIndex >= str.length())
            return 0;

        if (memo[strIndex][subIndex] != -1)
            return memo[strIndex][subIndex];

        if (str.charAt(strIndex) == subsequence.charAt(subIndex)) {
            memo[strIndex][subIndex] = (findSubCount(str, subsequence, strIndex + 1, subIndex + 1, memo) % MODULO) +
                    (findSubCount(str, subsequence, strIndex + 1, subIndex, memo) % MODULO) % MODULO;
            return memo[strIndex][subIndex];
        }

        memo[strIndex][subIndex] = findSubCount(str, subsequence, strIndex + 1, subIndex, memo) % MODULO;
        return memo[strIndex][subIndex];
    }
}

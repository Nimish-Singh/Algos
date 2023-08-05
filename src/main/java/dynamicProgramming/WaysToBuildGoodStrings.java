package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/count-ways-to-build-good-strings/
public class WaysToBuildGoodStrings {
    int mod = 1_000_000_007;

    // https://leetcode.com/problems/count-ways-to-build-good-strings/editorial/
    public int countGoodStrings(int low, int high, int zero, int one) {
//        int answer = 0;
//        for (int stringLength = low; stringLength <= high; stringLength++) {
//            answer += recursive(stringLength, zero, one);
//            answer %= mod;
//        }
//        return answer;

//        int[] memo = new int[high + 1];
//        Arrays.fill(memo, -1);
//        memo[0] = 1;
//
//        int answer = 0;
//        for (int end = low; end <= high; ++end) {
//            answer += topDown(end, zero, one, memo);
//            answer %= mod;
//        }
//        return answer;

        return bottomUp(low, high, zero, one);
    }

    private int topDown(int end, int zero, int one, int[] memo) {
        if (memo[end] != -1)
            return memo[end];
        int count = 0;
        if (end >= one) {
            count += topDown(end - one, zero, one, memo);
        }
        if (end >= zero) {
            count += topDown(end - zero, zero, one, memo);
        }
        memo[end] = count % mod;
        return memo[end];
    }

    private int recursive(int stringLength, int zero, int one) {
        if (stringLength == 0)
            return 1;

        int count = 0;
        if (stringLength >= one) {
            count += recursive(stringLength - one, zero, one);
        }
        if (stringLength >= zero) {
            count += recursive(stringLength - zero, zero, one);
        }
        return count % mod;
    }

    private int bottomUp(int low, int high, int zero, int one) {
        int[] memo = new int[high + 1];
        memo[0] = 1;

        for (int stringLength = 1; stringLength < memo.length; stringLength++) {
            if (stringLength >= zero)
                memo[stringLength] += memo[stringLength - zero];
            if (stringLength >= one)
                memo[stringLength] += memo[stringLength - one];
            memo[stringLength] %= mod;
        }

        int answer = 0;
        for (int index = low; index <= high; index++) {
            answer += memo[index];
            answer %= mod;
        }

        return answer;
    }
}

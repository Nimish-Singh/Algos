package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ones-and-zeroes/
public class OnesAndZeroes {
    private int[][] preComputed;

    public int findMaxForm(String[] strs, int m, int n) {
        preComputed = new int[strs.length][2];
        for (int index = 0; index < strs.length; index++) {
            char[] chars = strs[index].toCharArray();
            for (char c : chars)
                if (c == '0')
                    preComputed[index][0]++;
                else
                    preComputed[index][1]++;
        }

//        return recursive(strs, m, n, 0);

        Map<String, Integer> memo = new HashMap<>();
        return topDown(strs, m, n, 0, memo);
    }

    private int topDown(String[] strs, int allowedZeros, int allowedOnes, int index, Map<String, Integer> memo) {
        if (allowedZeros < 0 || allowedOnes < 0 || index >= strs.length)
            return 0;

        String key = allowedZeros + "|" + allowedOnes + "|" + index;
        if (memo.get(key) != null)
            return memo.get(key);

        int onTakingThisInput = 0;

        if (preComputed[index][0] <= allowedZeros && preComputed[index][1] <= allowedOnes) {
            onTakingThisInput = 1 + topDown(strs, allowedZeros - preComputed[index][0], allowedOnes - preComputed[index][1], index + 1, memo);
        }
        int onNotTakingThisInput = topDown(strs, allowedZeros, allowedOnes, index + 1, memo);

        memo.put(key, Math.max(onTakingThisInput, onNotTakingThisInput));
        return memo.get(key);
    }

    private int recursive(String[] strs, int allowedZeros, int allowedOnes, int index) {
        if (allowedZeros < 0 || allowedOnes < 0 || index >= strs.length)
            return 0;

        int onTakingThisInput = 0;

        if (preComputed[index][0] <= allowedZeros && preComputed[index][1] <= allowedOnes) {
            onTakingThisInput = 1 + recursive(strs, allowedZeros - preComputed[index][0], allowedOnes - preComputed[index][1], index + 1);
        }
        int onNotTakingThisInput = recursive(strs, allowedZeros, allowedOnes, index + 1);

        return Math.max(onTakingThisInput, onNotTakingThisInput);
    }
}

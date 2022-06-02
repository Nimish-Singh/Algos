package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

// https://leetcode.com/problems/perfect-squares/
public class MinSquaresForSum {
    public int numSquares(int n) {
        if (n <= 3)
            return n;

//        return recursive(n);

//        int[] memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        IntStream.range(0, 4).forEach(i -> memo[i] = i);
//        return topDown(n, memo);

        return bottomUp(n);
    }

    private int bottomUp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int index = 2; index <= n; index++) {
            memo[index] = Integer.MAX_VALUE;

            for (int num = 1; num <= index; num++) {
                int square = num * num;

                if (square > index)
                    break;
                memo[index] = Math.min(memo[index], 1 + memo[index - square]);
            }
        }
        return memo[n];
    }

    private int topDown(int n, int[] memo) {
        if (memo[n] != -1)
            return memo[n];

        int minNums = n;

        for (int num = 1; num <= n; num++) {
            int square = num * num;

            if (square > n)
                break;
            minNums = Math.min(minNums, 1 + numSquares(n - square));
        }
        memo[n] = minNums;
        return memo[n];
    }

    private int recursive(int n) {
        if (n <= 3)
            return n;

        int minNums = n;

        for (int num = 1; num <= n; num++) {
            int square = num * num;

            if (square > n)
                break;
            minNums = Math.min(minNums, 1 + numSquares(n - square));
        }
        return minNums;
    }
}

package dynamicProgramming;

// https://leetcode.com/problems/delete-and-earn
public class DeleteAndEarn {
    // https://leetcode.com/problems/delete-and-earn/solutions/777526/java-recursive-memoization-bottom-up/
    public int deleteAndEarn(int[] nums) {
        int[] counts = new int[10000 + 1];
        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) {
            counts[num]++;
            maxNum = Math.max(maxNum, num);
        }

//        return recursive(counts, maxNum);
        int[] memo = new int[10000 + 1];
//        return topDownDp(counts, maxNum, memo);

        return bottomUpDp(counts, maxNum);
    }

    private int bottomUpDp(int[] counts, int maxNum) {
        int[] memo = new int[maxNum + 1];
        memo[0] = 0;
        memo[1] = counts[1];

        for (int index = 2; index < memo.length; index++) {
            memo[index] = Math.max((counts[index] * index) + memo[index - 2], memo[index - 1]);
        }
        return memo[maxNum];
    }

    private int topDownDp(int[] counts, int numberToConsider, int[] memo) {
        if (numberToConsider <= 0)
            return 0;

        if (memo[numberToConsider] != 0)
            return memo[numberToConsider];

        memo[numberToConsider] = Math.max((numberToConsider * counts[numberToConsider]) + topDownDp(counts, numberToConsider - 2, memo),
            topDownDp(counts, numberToConsider - 1, memo));
        return memo[numberToConsider];
    }

    private int recursive(int[] counts, int numberToConsider) {
        if (numberToConsider <= 0)
            return 0;

        return Math.max((numberToConsider * counts[numberToConsider]) + recursive(counts, numberToConsider - 2),
            recursive(counts, numberToConsider - 1));
    }
}

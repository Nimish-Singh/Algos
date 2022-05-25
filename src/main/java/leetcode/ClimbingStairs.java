package leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
//        return recursion(n);

        return bottomUp(n);
    }

    private int bottomUp(int n) {
        if (n < 1)
            return 0;

        if (n == 1 || n == 2)
            return n;

        int[] climbWays = new int[n + 1];
        climbWays[0] = 0;
        climbWays[1] = 1;
        climbWays[2] = 2;

        for (int index = 3; index <= n; index++)
            climbWays[index] = climbWays[index - 1] + climbWays[index - 2];

        return climbWays[n];
    }

    private int recursion(int n) {
        if (n < 1)
            return 0;

        if (n == 1 || n == 2)
            return n;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

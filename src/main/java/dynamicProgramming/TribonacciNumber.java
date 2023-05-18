package dynamicProgramming;

// https://leetcode.com/problems/n-th-tribonacci-number/description/
public class TribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;

        if (n <= 2)
            return 1;

        int[] trib = new int[n + 1];
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;

        for (int index = 3; index <= n; index++)
            trib[index] = trib[index - 1] + trib[index - 2] + trib[index - 3];

        return trib[n];
    }
}

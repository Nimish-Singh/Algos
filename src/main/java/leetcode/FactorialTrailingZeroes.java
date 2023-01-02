package leetcode;

// https://leetcode.com/problems/factorial-trailing-zeroes/description/
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;

        int zeroesCount = 0;
        while (n > 0) {
            zeroesCount += n / 5;
            n /= 5;
        }

        /*
        Or, use this loop (more readable but uses Math.pow method):
        for (int power = 1; Math.pow(5, power) >= n; power++) {
            zeroesCount += n / Math.pow(5, power);
        }
         */
        return zeroesCount;
    }
}

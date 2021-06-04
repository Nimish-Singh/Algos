package leetcode;

public class Divide2Integers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;

        if (dividend == 0)
            return 0;

        if (dividend == divisor)
            return 1;

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        long sum = divisor, i = 1;
        while (Math.abs(sum) <= Math.abs((long) dividend)) {
            sum += divisor;
            ++i;
        }

        return i > Integer.MAX_VALUE ? sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE
                : (int) (sign * (i - 1));
    }
}

package leetcode;

// https://leetcode.com/problems/number-of-even-and-odd-bits/description/
public class EvenOddBItCount {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        boolean isOddPosition = false;

        while (n > 0) {
            int bit = n & 1;
            if (bit == 1) {
                if (isOddPosition)
                    odd++;
                else
                    even++;
            }
            n = n >> 1;
            isOddPosition = !isOddPosition;
        }

        return new int[]{even, odd};
    }
}

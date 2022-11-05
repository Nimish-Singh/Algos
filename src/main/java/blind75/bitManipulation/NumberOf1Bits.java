package blind75.bitManipulation;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        for (int index = 0; index < 32; index++) {
            if ((n & 1) == 1)
                count++;

            n = n >> 1;
        }
        return count;
    }
}

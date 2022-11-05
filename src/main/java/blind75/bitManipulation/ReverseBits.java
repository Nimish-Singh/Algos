package blind75.bitManipulation;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {
    public int reverseBits(int n) {
        int answer = 0;
        for (int iteration = 0; iteration < 32; iteration++) {
            if ((n & 1) == 1) {
                answer = answer | 1; // can also do answer++;
            }

            // Don't shift the last bit to the left
            if (iteration != 31)
                answer = answer << 1;
            n = n >>> 1;
        }
        return answer;
    }
}

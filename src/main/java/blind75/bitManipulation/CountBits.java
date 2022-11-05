package blind75.bitManipulation;

// https://leetcode.com/problems/counting-bits/
public class CountBits {
    public int[] countBits(int n) {
//        return bruteForce(n);

        return smarter(n);
    }

    // https://leetcode.com/problems/counting-bits/discuss/79539/Three-Line-Java-Solution
    private int[] smarter(int n) {
        // if n is even, then number of 1 bits in n = number of 1 bits in n/2 (which is n >> 1)
        // if n is odd, then number of 1 bits in n = number of 1 bits in n/2 + 1
        int[] answer = new int[n + 1];
        for (int number = 0; number <= n; number++)
            answer[number] = answer[number >> 1] + (number & 1);
        return answer;
    }

    private int[] bruteForce(int n) {
        int[] answer = new int[n + 1];
        for (int number = 0; number <= n; number++)
            answer[number] = countBitsFor(number);
        return answer;
    }

    private int countBitsFor(int number) {
        int count = 0;
        while (number != 0) {
            count += number & 1;
            number = number >> 1;
        }
        return count;
    }
}

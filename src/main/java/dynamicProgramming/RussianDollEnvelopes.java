package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/russian-doll-envelopes/
public class RussianDollEnvelopes {
    // https://leetcode.com/problems/russian-doll-envelopes/solutions/82763/java-nlogn-solution-with-explanation/
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] memo = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(memo, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }

            memo[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }
}

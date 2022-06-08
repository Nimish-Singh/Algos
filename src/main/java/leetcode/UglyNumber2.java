package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/ugly-number-ii/
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
//        return heapApproach(n);

        return dpApproach(n);
    }

    private int dpApproach(int n) {
        if (n <= 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = 1;
        int i2, i3, i5;
        i2 = i3 = i5 = 0;

        for (int index = 1; index < n; index++) {
            int nextSmallestUglyNumber = Math.min(dp[i5] * 5, Math.min(dp[i2] * 2, dp[i3] * 3));

            dp[index] = nextSmallestUglyNumber;

            if (nextSmallestUglyNumber == dp[i5] * 5) {
                i5++;
            }
            if (nextSmallestUglyNumber == dp[i3] * 3) {
                i3++;
            }
            if (nextSmallestUglyNumber == dp[i2] * 2) {
                i2++;
            }
        }
        return dp[n - 1];
    }

    private int heapApproach(int n) {
        if (n <= 0)
            return 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> alreadInserted = new HashSet<>();
        int[] factors = {2, 3, 5};

        minHeap.offer(1L);
        Long result = 0L;

        for (int i = 0; i < n; i++) {
            result = minHeap.poll();

            for (int factor : factors) {
                if (!alreadInserted.contains(factor * result)) {
                    alreadInserted.add(factor * result);
                    minHeap.offer(factor * result);
                }
            }
        }
        return result.intValue();
    }
}

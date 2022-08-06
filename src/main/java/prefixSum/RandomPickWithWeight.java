package prefixSum;

import java.util.Random;

// https://leetcode.com/problems/random-pick-with-weight/
public class RandomPickWithWeight {
    private Random random;
    private int[] sum;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        sum = new int[w.length];
        sum[0] = w[0];

        for (int index = 1; index < w.length; index++) {
            sum[index] = sum[index - 1] + w[index];
        }
    }

    public int pickIndex() {
        int length = sum.length;
        int index = random.nextInt(sum[length - 1]) + 1;
        int left = 0, right = length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == index)
                return mid;
            if (sum[mid] < index)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

package slidingWindow;

// https://leetcode.com/problems/grumpy-bookstore-owner/description/
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfiedAlready = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                satisfiedAlready += customers[i];
        }

        int maxGain = 0, gain = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < customers.length; windowEnd++) {
            if (grumpy[windowEnd] == 1)
                gain += customers[windowEnd];

            if (windowEnd - windowStart + 1 > minutes) {
                if (grumpy[windowStart] == 1) {
                    gain -= customers[windowStart];
                }
                windowStart++;
            }

            if (windowEnd - windowStart + 1 == minutes) {
                maxGain = Math.max(maxGain, gain);
            }
        }

        return satisfiedAlready + maxGain;
    }
}

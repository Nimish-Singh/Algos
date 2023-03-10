package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
public class GiftFromRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.comparingLong(a -> (long) a).reversed());

        for (int gift : gifts) {
            maxHeap.offer((long) gift);
        }

        for (int second = 1; second <= k; second++) {
            Long largestGift = maxHeap.poll();
            maxHeap.offer((long) Math.sqrt((double) largestGift));
        }

        return maxHeap.stream().mapToLong(Long::longValue).sum();
    }
}

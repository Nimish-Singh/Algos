package blind75.heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
    private final Queue<Integer> lowerHalf;
    private final Queue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        upperHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lowerHalf.size() == upperHalf.size()) {
            lowerHalf.offer(num);
            upperHalf.offer(lowerHalf.poll());
        } else {
            upperHalf.offer(num);
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
        return upperHalf.peek().doubleValue();
    }
}

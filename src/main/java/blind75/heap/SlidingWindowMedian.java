package blind75.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/sliding-window-median/
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        return heapApproach(nums, k);
        // can also be done via TreeSet- https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)
    }

    private double[] heapApproach(int[] nums, int k) {
        Queue<Integer> lowerHalf = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> upperHalf = new PriorityQueue<>();

        int numberOfIterations = nums.length - k + 1;
        double[] answer = new double[numberOfIterations];
        int answerIndex = 0;

        for (int index = 0; index < k; index++)
            addElementToHeap(lowerHalf, upperHalf, nums[index]);

        answer[answerIndex] = getMedian(lowerHalf, upperHalf);
        answerIndex++;
        for (int index = k; index < nums.length; index++) {
            remove(lowerHalf, upperHalf, nums[index - k]);
            addElementToHeap(lowerHalf, upperHalf, nums[index]);
            answer[answerIndex] = getMedian(lowerHalf, upperHalf);
            answerIndex++;
        }
        return answer;
    }

    private void remove(Queue<Integer> lowerHalf, Queue<Integer> upperHalf, int num) {
        if (num < getMedian(lowerHalf, upperHalf)) {
            lowerHalf.remove(num);
        } else {
            upperHalf.remove(num);
        }
        if (upperHalf.size() < lowerHalf.size()) { // rebalancing
            upperHalf.offer(lowerHalf.poll());
        }
        if (upperHalf.size() - lowerHalf.size() > 1) { // rebalancing
            lowerHalf.offer(upperHalf.poll());
        }
    }

    private void addElementToHeap(Queue<Integer> lowerHalf, Queue<Integer> upperHalf, int num) {
        if (lowerHalf.size() == upperHalf.size()) {
            lowerHalf.offer(num);
            upperHalf.offer(lowerHalf.poll());
            return;
        }
        upperHalf.offer(num);
        lowerHalf.offer(upperHalf.poll());
    }

    private double getMedian(Queue<Integer> lowerHalf, Queue<Integer> upperHalf) {
        if (lowerHalf.size() == upperHalf.size()) {
            return lowerHalf.peek() / 2.0 + upperHalf.peek() / 2.0;
        }
        return upperHalf.peek();
    }
}

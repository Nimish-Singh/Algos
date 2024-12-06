package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int index = 0; index < nums.length; index++) {
            if (!deque.isEmpty() && deque.peekFirst() < index - k + 1)
                deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[index])
                deque.pollLast();

            deque.offer(index);

            if (index >= k - 1)
                answer.add(nums[deque.peekFirst()]);
        }

        return answer.stream()
                .mapToInt(x -> x)
                .toArray();
    }
}

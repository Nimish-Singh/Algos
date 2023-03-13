package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/count-distinct-numbers-on-board/description/
public class CountDistinctNumbersOnBoard {
    public int distinctIntegers(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> elements = new HashSet<>();

        elements.add(n);
        queue.offer(n);

        while (!queue.isEmpty()) {
            int sizeAtThisIteration = queue.size();

            for (int index = 0; index < sizeAtThisIteration; index++) {
                Integer element = queue.poll();
                for (int divisor = element; divisor > 0; divisor--) {
                    if (element % divisor == 1 && !elements.contains(divisor)) {
                        elements.add(divisor);
                        queue.offer(divisor);
                    }
                }
            }
        }

        return elements.size();
    }
}

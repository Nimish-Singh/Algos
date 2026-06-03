package priorityQueue;

import java.util.*;

public class KPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        Set<String> visited = new HashSet<>();
        minHeap.offer(new int[]{0, 0});

        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            int[] topElement = minHeap.poll();
            answer.add(List.of(nums1[topElement[0]], nums2[topElement[1]]));

            int[] newKeyRight = new int[]{topElement[0] + 1, topElement[1]};
            if (topElement[0] + 1 < nums1.length && !visited.contains(getKey(newKeyRight))) {
                minHeap.offer(newKeyRight);
                visited.add(getKey(newKeyRight));
            }

            int[] newKeyDown = new int[]{topElement[0], topElement[1] + 1};
            if (topElement[1] + 1 < nums2.length && !visited.contains(getKey(newKeyDown))) {
                minHeap.offer(newKeyDown);
                visited.add(getKey(newKeyDown));
            }
        }

        return answer;
    }

    private String getKey(int[] element) {
        return element[0] + "@" + element[1];
    }
}

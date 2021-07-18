package leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> distanceFromOrigin(b) - distanceFromOrigin(a));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] result = new int[k][2];
        for (int index = k - 1; index >= 0; index--)
            result[index] = maxHeap.poll();
        return result;
    }

    private int distanceFromOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

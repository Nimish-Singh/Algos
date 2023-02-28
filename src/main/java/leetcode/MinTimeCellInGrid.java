package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/
public class MinTimeCellInGrid {
    /*
    Solution approach: https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/solutions/3231527/back-n-forth-dijkstra/
    and https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/solutions/3231168/simple-java-solution-with-explanation-using-priority-queue/
     */
    public int minimumTime(int[][] grid) {
        if (grid[1][0] > 1 && grid[0][1] > 1) {
            return -1;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[rows][columns];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        minHeap.offer(new int[]{0, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] element = minHeap.poll();
            // row = element[0]. column = element[1]. time = element[2]
            int currentRow = element[0];
            int currentColumn = element[1];
            int currentTime = element[2];

            if (currentRow == rows - 1 && currentColumn == columns - 1) {
                return currentTime;
            }

            if (visited[currentRow][currentColumn]) {
                continue;
            }
            visited[currentRow][currentColumn] = true;

            for (int index = 0; index < 4; index++) {
                int newRow = currentRow + directions[index][0];
                int newColumn = currentColumn + directions[index][1];

                if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns || visited[newRow][newColumn]) {
                    continue;
                }

                int timeDifference = grid[newRow][newColumn] - currentTime;
                if (timeDifference <= 1) {
                    minHeap.offer(new int[]{newRow, newColumn, currentTime + 1});
                } else {
                    if (timeDifference % 2 == 1) {
                        minHeap.offer(new int[]{newRow, newColumn, grid[newRow][newColumn]});
                    } else {
                        minHeap.offer(new int[]{newRow, newColumn, grid[newRow][newColumn] + 1});
                    }
                }
            }
        }
        return -1;
    }
}

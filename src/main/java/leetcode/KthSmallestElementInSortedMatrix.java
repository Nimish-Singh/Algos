package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
//        return usingMinheap(matrix, k);
        return usingValueBasedBinarySearch(matrix, k);
    }

    private int usingValueBasedBinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;

            // first number is the smallest and the second number is the largest
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};

            int count = countLessEqual(matrix, mid, smallLargePair);

            if (count == k)
                return smallLargePair[0];

            if (count < k)
                start = smallLargePair[1]; // search higher
            else
                end = smallLargePair[0]; // search lower
        }
        return start;
    }

    private int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid, let's keep track of the
                // smallest number greater than the mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                // as matrix[row][col] is less than or equal to the mid, let's keep track of the
                // biggest number less than or equal to the mid
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }

    private int usingMinheap(int[][] matrix, int k) {
        PriorityQueue<CellCoordinates> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> matrix[n.row][n.column]));

        for (int rowIndex = 0; rowIndex < matrix.length && rowIndex < k; rowIndex++)
            minHeap.add(new CellCoordinates(rowIndex, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            CellCoordinates coordinates = minHeap.poll();
            result = matrix[coordinates.row][coordinates.column];
            if (++numberCount == k)
                break;
            coordinates.column++;
            if (matrix[0].length > coordinates.column)
                minHeap.add(coordinates);
        }
        return result;
    }
}

class CellCoordinates {
    int row;
    int column;

    CellCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

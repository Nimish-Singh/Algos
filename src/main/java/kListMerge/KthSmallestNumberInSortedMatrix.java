package kListMerge;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given an N*N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix
public class KthSmallestNumberInSortedMatrix {
    public int find(int[][] matrix, int k) {
        PriorityQueue<ElementIndex> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a.row][a.col]));

        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.offer(new ElementIndex(i, 0));

        int count = 0, result = 0;
        while (!minHeap.isEmpty()) {
            ElementIndex elementIndex = minHeap.poll();
            result = matrix[elementIndex.row][elementIndex.col];

            if (++count == k)
                break;
            elementIndex.col++;

            if (matrix[elementIndex.row].length > elementIndex.col)
                minHeap.offer(elementIndex);

        }
        return result;
    }
}

class ElementIndex {
    int row, col;

    public ElementIndex(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestElementInSortedMatrixTest {
    private KthSmallestElementInSortedMatrix find = new KthSmallestElementInSortedMatrix();
    private int[][] matrix;

    @Test
    public void sampleInput1() {
        matrix = new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        assertEquals(13, find.kthSmallest(matrix, 8));
    }

    @Test
    public void sampleInput2() {
        matrix = new int[][]{{-5}};
        assertEquals(-5, find.kthSmallest(matrix, 1));
    }

    @Test
    public void sampleInput3() {
        matrix = new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        assertEquals(5, find.kthSmallest(matrix, 2));
    }
}

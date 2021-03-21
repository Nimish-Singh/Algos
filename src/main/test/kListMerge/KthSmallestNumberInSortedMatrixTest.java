package kListMerge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestNumberInSortedMatrixTest {
    private KthSmallestNumberInSortedMatrix number = new KthSmallestNumberInSortedMatrix();

    @Test
    public void sampleInput1() {
        int[][] matrix = new int[][]{
                {2, 6, 8},
                {3, 7, 10},
                {5, 8, 11}
        };
        assertEquals(7, number.find(matrix, 5));
    }
}

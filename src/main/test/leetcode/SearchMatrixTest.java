package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchMatrixTest {
    private SearchMatrix searcher = new SearchMatrix();
    private int[][] matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
    };

    @Test
    public void sampleInput1() {
        assertTrue(searcher.searchMatrix(matrix, 3));
    }

    @Test
    public void sampleInput2() {
        assertFalse(searcher.searchMatrix(matrix, 13));
    }

    @Test
    public void sampleInput3() {
        matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        assertTrue(searcher.searchMatrix(matrix, 23));
    }
}

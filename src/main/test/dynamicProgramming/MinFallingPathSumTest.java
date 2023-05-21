package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinFallingPathSumTest {
    private final MinFallingPathSum min = new MinFallingPathSum();
    private int[][] matrix;

    @Test
    public void sampleInput1() {
        matrix = new int[][]{{2, 1, 3},
                             {6, 5, 4},
                             {7, 8, 9}};
        assertEquals(13, min.minFallingPathSum(matrix));
    }

    @Test
    public void sampleInput2() {
        matrix = new int[][]{{-19, 57},
                             {-40, -5}};
        assertEquals(-59, min.minFallingPathSum(matrix));
    }
}

package blind75.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SetMatrixZeroesTest {
    private final SetMatrixZeroes set = new SetMatrixZeroes();
    private int[][] matrix;

    @Test
    public void sampleInput1() {
        matrix = new int[][]{{1, 1, 1},
                             {1, 0, 1},
                             {1, 1, 1}};
        set.setZeroes(matrix);
        assertArrayEquals(new int[]{1, 0, 1}, matrix[0]);
        assertArrayEquals(new int[]{0, 0, 0}, matrix[1]);
        assertArrayEquals(new int[]{1, 0, 1}, matrix[2]);
    }

    @Test
    public void sampleInput2() {
        matrix = new int[][]{{0, 1, 2, 0},
                             {3, 4, 5, 2},
                             {1, 3, 1, 5}};
        set.setZeroes(matrix);
        assertArrayEquals(new int[]{0, 0, 0, 0}, matrix[0]);
        assertArrayEquals(new int[]{0, 4, 5, 0}, matrix[1]);
        assertArrayEquals(new int[]{0, 3, 1, 0}, matrix[2]);
    }
}

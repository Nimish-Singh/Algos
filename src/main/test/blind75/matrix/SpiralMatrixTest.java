package blind75.matrix;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SpiralMatrixTest {
    private final SpiralMatrix sm = new SpiralMatrix();
    private int[][] matrix;

    @Test
    public void sampleInput1() {
        matrix = new int[][]{{1, 2, 3},
                             {4, 5, 6},
                             {7, 8, 9}};
        List<Integer> spiral = sm.spiralOrder(matrix);
        assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, spiral.stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        matrix = new int[][]{{1, 2, 3, 4},
                             {5, 6, 7, 8},
                             {9, 10, 11, 12}};
        List<Integer> spiral = sm.spiralOrder(matrix);
        assertArrayEquals(new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}, spiral.stream().mapToInt(x -> x).toArray());
    }
}

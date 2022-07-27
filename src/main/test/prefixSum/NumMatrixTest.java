package prefixSum;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumMatrixTest {
    private NumMatrix nm;

    @Test
    public void sampleInput1() {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2},
                                  {5, 6, 3, 2, 1},
                                  {1, 2, 0, 1, 5},
                                  {4, 1, 0, 1, 7},
                                  {1, 0, 3, 0, 5}};
        nm = new NumMatrix(matrix);

        assertEquals(8, nm.sumRegion(2, 1, 4, 3));
        assertEquals(11, nm.sumRegion(1, 1, 2, 2));
        assertEquals(12, nm.sumRegion(1, 2, 2, 4));
    }
}

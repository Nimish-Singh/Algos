package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximalSquareTest {
    private final MaximalSquare ms = new MaximalSquare();
    private char[][] matrix;

    @Test
    public void sampleInput1() {
        matrix = new char[][]{{'1', '0', '1', '0', '0'},
                              {'1', '0', '1', '1', '1'},
                              {'1', '1', '1', '1', '1'},
                              {'1', '0', '0', '1', '0'}};
        assertEquals(4, ms.maximalSquare(matrix));
    }

    @Test
    public void sampleInput2() {
        matrix = new char[][]{{'0', '1'},
                              {'1', '0'}};
        assertEquals(1, ms.maximalSquare(matrix));
    }

    @Test
    public void sampleInput3() {
        matrix = new char[][]{{'0'}};
        assertEquals(0, ms.maximalSquare(matrix));
    }
}

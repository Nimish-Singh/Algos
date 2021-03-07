package twoPointer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortedSquaresTest {
    private SortedSquares sortedSquares = new SortedSquares();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new int[]{0, 1, 4, 4, 9}, sortedSquares.makeSquares(new int[]{-2, -1, 0, 2, 3}));
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new int[]{0, 1, 1, 4, 9}, sortedSquares.makeSquares(new int[]{-3, -1, 0, 1, 2}));
    }
}

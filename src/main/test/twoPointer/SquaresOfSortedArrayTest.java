package twoPointer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SquaresOfSortedArrayTest {
    private final SquaresOfSortedArray squares = new SquaresOfSortedArray();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{-4, -1, 0, 3, 10};
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, squares.sortedSquares(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{-7, -3, 2, 3, 11};
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, squares.sortedSquares(nums));

    }

    @Test
    public void sampleInput3() {
        nums = new int[]{-7};
        assertArrayEquals(new int[]{49}, squares.sortedSquares(nums));
    }

    @Test
    public void sampleInput4() {
        nums = new int[]{-7, -5, -3};
        assertArrayEquals(new int[]{9, 25, 49}, squares.sortedSquares(nums));
    }

    @Test
    public void sampleInput5() {
        nums = new int[]{4, 5, 9};
        assertArrayEquals(new int[]{16, 25, 81}, squares.sortedSquares(nums));
    }
}

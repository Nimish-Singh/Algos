package twoPointer;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MoveZerosTest {
    private final MoveZeros move = new MoveZeros();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{0, 1, 0, 3, 12};
        move.moveZeroes(nums);

        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{0};
        move.moveZeroes(nums);

        assertArrayEquals(new int[]{0}, nums);
    }
}

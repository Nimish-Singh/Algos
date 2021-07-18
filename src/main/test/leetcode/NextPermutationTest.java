package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutationTest {
    private NextPermutation finder = new NextPermutation();
    private int[] input;

    @Test
    public void sampleInput1() {
        input = new int[]{1, 2, 3};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{1, 3, 2}, input);
    }

    @Test
    public void sampleInput2() {
        input = new int[]{3, 2, 1};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{1, 2, 3}, input);
    }

    @Test
    public void sampleInput3() {
        input = new int[]{1, 1, 5};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{1, 5, 1}, input);
    }

    @Test
    public void sampleInput4() {
        input = new int[]{1};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{1}, input);
    }

    @Test
    public void sampleInput5() {
        input = new int[]{4, 5, 3, 1};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{5, 1, 3, 4}, input);
    }

    @Test
    public void sampleInput6() {
        input = new int[]{1, 2, 6, 3, 1};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{1, 3, 1, 2, 6}, input);
    }

    @Test
    public void sampleInput7() {
        input = new int[]{1, 5, 1};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{5, 1, 1}, input);
    }

    @Test
    public void sampleInput8() {
        input = new int[]{5, 1, 1};
        finder.nextPermutation(input);
        assertArrayEquals(new int[]{1, 1, 5}, input);
    }
}

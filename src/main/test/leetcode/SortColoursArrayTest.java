package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortColoursArrayTest {
    private SortColoursArray array = new SortColoursArray();
    private int[] colours;

    @Test
    public void sampleInput1() {
        colours = new int[]{2, 0, 2, 1, 1, 0};
        array.sortColors(colours);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, colours);
    }

    @Test
    public void sampleInput2() {
        colours = new int[]{2, 0, 1};
        array.sortColors(colours);
        assertArrayEquals(new int[]{0, 1, 2}, colours);
    }

    @Test
    public void sampleInput3() {
        colours = new int[]{0};
        array.sortColors(colours);
        assertArrayEquals(new int[]{0}, colours);
    }

    @Test
    public void sampleInput4() {
        colours = new int[]{1};
        array.sortColors(colours);
        assertArrayEquals(new int[]{1}, colours);
    }
}

package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConvertToNegativeBaseTest {
    private final ConvertToNegativeBase convertToNegativeBase = new ConvertToNegativeBase();
    private int[] bits;

    @Test
    public void sampleInput1() {
        bits = new int[]{1, 0, 0, 1, 1};
        assertArrayEquals(new int[]{1, 0, 1}, convertToNegativeBase.solution(bits));
    }

    @Test
    public void sampleInput2() {
        bits = new int[]{1, 0, 0, 1, 1, 1};
        assertArrayEquals(new int[]{1, 0, 1, 0, 1, 1}, convertToNegativeBase.solution(bits));
    }

    @Test
    public void sampleInput3() {
        bits = new int[]{0};
        assertArrayEquals(new int[]{0}, convertToNegativeBase.solution(bits));
    }

    @Test
    public void sampleInput4() {
        bits = new int[]{};
        assertArrayEquals(new int[]{}, convertToNegativeBase.solution(bits));
    }
}

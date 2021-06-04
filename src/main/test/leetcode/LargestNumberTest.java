package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestNumberTest {
    private LargestNumber largestNumber = new LargestNumber();

    @Test
    public void sampleInput1() {
        assertEquals("210", largestNumber.largestNumber(new int[]{10, 2}));
    }

    @Test
    public void sampleInput2() {
        assertEquals("9534330", largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void sampleInput3() {
        assertEquals("1", largestNumber.largestNumber(new int[]{1}));
    }

    @Test
    public void sampleInput4() {
        assertEquals("10", largestNumber.largestNumber(new int[]{10}));
    }
}
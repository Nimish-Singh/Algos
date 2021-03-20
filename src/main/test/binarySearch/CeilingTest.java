package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CeilingTest {
    private Ceiling ceiling = new Ceiling();

    @Test
    public void sampleInput1() {
        assertEquals(1, ceiling.find(new int[] {4, 6, 35}, 6));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, ceiling.find(new int[] {4, 6, 35}, 16));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, ceiling.find(new int[] {4, 6, 35}, -6));
    }

    @Test
    public void sampleInput4() {
        assertEquals(-1, ceiling.find(new int[] {4, 6, 30}, 40));
    }
}

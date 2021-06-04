package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchRotatedArrayTest {
    private SearchRotatedArray rotatedArray = new SearchRotatedArray();

    @Test
    public void sampleInput1() {
        assertEquals(4, rotatedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    public void sampleInput2() {
        assertEquals(-1, rotatedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    public void sampleInput3() {
        assertEquals(-1, rotatedArray.search(new int[]{1}, 0));
    }

    @Test
    public void sampleInput4() {
        assertEquals(4, rotatedArray.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }
}

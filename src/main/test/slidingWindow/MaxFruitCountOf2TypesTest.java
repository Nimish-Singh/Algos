package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxFruitCountOf2TypesTest {
    private MaxFruitCountOf2Types fruits = new MaxFruitCountOf2Types();

    @Test
    public void sampleInput1() {
        assertEquals(3, fruits.findTotal(new char[] {'A', 'B', 'C', 'A', 'C'}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, fruits.findTotal(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}

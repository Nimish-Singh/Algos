package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDistinctNumbersOnBoardTest {
    private final CountDistinctNumbersOnBoard c = new CountDistinctNumbersOnBoard();

    @Test
    public void sampleInput1() {
        assertEquals(4, c.distinctIntegers(5));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, c.distinctIntegers(3));
    }
}

package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeIntegerBeautifulTest {
    private final MakeIntegerBeautiful make = new MakeIntegerBeautiful();

    @Test
    public void sampleInput1() {
        assertEquals(4, make.makeIntegerBeautiful(16, 6));
    }

    @Test
    public void sampleInput2() {
        assertEquals(33, make.makeIntegerBeautiful(467, 6));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, make.makeIntegerBeautiful(1, 1));
    }

    @Test
    public void sampleInput4() {
        assertEquals(65495273, make.makeIntegerBeautiful(734504727, 10));
    }
}

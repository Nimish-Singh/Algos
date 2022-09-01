package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringWithoutAAAAndBBBTest {
    private final StringWithoutAAAAndBBB s = new StringWithoutAAAAndBBB();

    @Test
    public void sampleInput1() {
        assertEquals("bab", s.strWithout3a3b(1, 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals("aabaa", s.strWithout3a3b(4, 1));
    }

    @Test
    public void sampleInput3() {
        assertEquals("bbabbab", s.strWithout3a3b(2, 5));
    }
}

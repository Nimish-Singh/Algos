package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReorganiseStringTest {
    private final ReorganiseString r = new ReorganiseString();

    @Test
    public void sampleInput1() {
        assertEquals("aba", r.reorganizeString("aab"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("", r.reorganizeString("aaab"));
    }
}

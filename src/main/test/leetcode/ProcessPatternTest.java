package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessPatternTest {
    private final ProcessPattern p = new ProcessPattern();

    @Test
    public void sampleInput1() {
        assertEquals("c1", p.processInput("c1"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("abc1c1bc1c1", p.processInput("a2{b2{c1}}"));
    }

    @Test
    public void sampleInput3() {
        assertEquals("abc1c1bc1c1xxxxxxxxxxxx", p.processInput("a2{b2{c1}}12{x}"));
    }

    @Test
    public void sampleInput4() {
        assertEquals("abc11c11bc11c11xxxxxxxxxxxx", p.processInput("a2{b2{c11}}12{x}"));
    }
}

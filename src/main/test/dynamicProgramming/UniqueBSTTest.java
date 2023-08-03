package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueBSTTest {
    private final UniqueBST u = new UniqueBST();

    @Test
    public void sampleInput1() {
        assertEquals(5, u.numTrees(3));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, u.numTrees(1));
    }
}

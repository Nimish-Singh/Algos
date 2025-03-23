package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompleteComponentsTest {
    private final CompleteComponents completeComponents = new CompleteComponents();
    private int[][] edges;

    @Test
    public void sampleInput1() {
        edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        assertEquals(3, completeComponents.countCompleteComponents(6, edges));
    }

    @Test
    public void sampleInput2() {
        edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
        assertEquals(1, completeComponents.countCompleteComponents(6, edges));
    }

    @Test
    public void sampleInput3() {
        edges = new int[][]{{2, 0}, {3, 1}, {3, 2}};
        assertEquals(0, completeComponents.countCompleteComponents(4, edges));
    }
}

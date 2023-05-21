package dynamicProgramming;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    private final Triangle t = new Triangle();

    @Test
    public void sampleInput1() {
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        assertEquals(11, t.minimumTotal(triangle));
    }

    @Test
    public void sampleInput2() {
        List<List<Integer>> triangle = List.of(List.of(-10));
        assertEquals(-10, t.minimumTotal(triangle));
    }
}

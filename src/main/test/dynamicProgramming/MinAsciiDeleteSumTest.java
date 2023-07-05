package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinAsciiDeleteSumTest {
    private final MinAsciiDeleteSum min = new MinAsciiDeleteSum();

    @Test
    public void sampleInput1() {
        assertEquals(231, min.minimumDeleteSum("sea", "eat"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(403, min.minimumDeleteSum("delete", "leet"));
    }
}

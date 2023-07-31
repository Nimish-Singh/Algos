package dynamicProgramming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DistinctSubsequencesTest {
    private final DistinctSubsequences ds = new DistinctSubsequences();

    @Test
    public void sampleInput1() {
        assertEquals(3, ds.numDistinct("rabbbit", "rabbit"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, ds.numDistinct("babgbag", "bag"));
    }
}

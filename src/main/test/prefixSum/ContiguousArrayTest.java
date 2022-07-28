package prefixSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContiguousArrayTest {
    private ContiguousArray ca = new ContiguousArray();

    @Test
    public void sampleInput1() {
        assertEquals(2, ca.findMaxLength(new int[]{0, 1}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, ca.findMaxLength(new int[]{0, 1, 0}));
    }
}

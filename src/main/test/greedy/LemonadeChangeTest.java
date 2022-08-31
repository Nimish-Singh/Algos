package greedy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LemonadeChangeTest {
    private final LemonadeChange change = new LemonadeChange();

    @Test
    public void sampleInput1() {
        assertTrue(change.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    @Test
    public void sampleInput2() {
        assertFalse(change.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}

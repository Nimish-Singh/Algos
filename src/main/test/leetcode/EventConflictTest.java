package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventConflictTest {
    private final EventConflict ec = new EventConflict();

    @Test
    public void sampleInput1() {
        assertTrue(ec.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
    }

    @Test
    public void sampleInput2() {
        assertTrue(ec.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
    }

    @Test
    public void sampleInput3() {
        assertFalse(ec.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }
}

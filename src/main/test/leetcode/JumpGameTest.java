package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JumpGameTest {
    private JumpGame game = new JumpGame();

    @Test
    public void sampleInput1() {
        assertTrue(game.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void sampleInput2() {
        assertFalse(game.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}

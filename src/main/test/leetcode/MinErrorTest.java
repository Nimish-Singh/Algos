package leetcode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinErrorTest {
    private final MinError minError = new MinError();

    @Test
    public void sampleInput1() {
        assertEquals(10, minError.minErrors("0!!1!1", 2, 3));
    }

    @Test
    public void sampleInput2() {
        assertEquals(0, minError.minErrors("!!!!!!!", 23, 47));
    }
}

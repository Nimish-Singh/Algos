package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumBoatsTest {
    private final MinimumBoats boats = new MinimumBoats();

    @Test
    public void sampleInput1() {
        assertEquals(1, boats.numRescueBoats(new int[]{1, 2}, 3));
    }
// 3 3 4 5, 5
    @Test
    public void sampleInput2() {
        assertEquals(4, boats.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    @Test
    public void sampleInput3() {
        assertEquals(3, boats.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }
// 1 3 4 7 8, 9
    @Test
    public void sampleInput4() {
        assertEquals(3, boats.numRescueBoats(new int[]{3, 8, 7, 1, 4}, 9));
    }
}

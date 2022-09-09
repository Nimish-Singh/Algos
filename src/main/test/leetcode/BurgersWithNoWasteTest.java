package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgersWithNoWasteTest {
    private final BurgersWithNoWaste burgerMaker = new BurgersWithNoWaste();

    @Test
    public void sampleInput1() {
        List<Integer> burgers = burgerMaker.numOfBurgers(16, 7);
        assertEquals(1, burgers.get(0).intValue());
        assertEquals(6, burgers.get(1).intValue());
    }

    @Test
    public void sampleInput2() {
        List<Integer> burgers = burgerMaker.numOfBurgers(17, 4);
        assertTrue(burgers.isEmpty());
    }

    @Test
    public void sampleInput3() {
        List<Integer> burgers = burgerMaker.numOfBurgers(4, 17);
        assertTrue(burgers.isEmpty());
    }
}

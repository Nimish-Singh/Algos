package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GasStationTest {
    private GasStation gs = new GasStation();
    private int[] gas;
    private int[] cost;

    @Test
    public void sampleInput1() {
        gas = new int[]{1, 2, 3, 4, 5};
        cost = new int[]{3, 4, 5, 1, 2};
        assertEquals(3, gs.canCompleteCircuit(gas, cost));
    }

    @Test
    public void sampleInput2() {
        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        assertEquals(-1, gs.canCompleteCircuit(gas, cost));
    }
}

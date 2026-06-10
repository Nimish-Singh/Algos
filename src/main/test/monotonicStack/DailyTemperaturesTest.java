package monotonicStack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DailyTemperaturesTest {
    private final DailyTemperatures dailyTemperatures = new DailyTemperatures();
    private int[] temperatures;

    @Test
    public void sampleInput1() {
        temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures.dailyTemperatures(temperatures));
    }

    @Test
    public void sampleInput2() {
        temperatures = new int[]{30, 40, 50, 60};
        assertArrayEquals(new int[]{1, 1, 1, 0}, dailyTemperatures.dailyTemperatures(temperatures));
    }

    @Test
    public void sampleInput3() {
        temperatures = new int[]{30, 60, 90};
        assertArrayEquals(new int[]{1, 1, 0}, dailyTemperatures.dailyTemperatures(temperatures));
    }
}

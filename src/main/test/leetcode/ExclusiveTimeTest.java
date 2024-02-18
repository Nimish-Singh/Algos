package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;
import java.util.Arrays;

public class ExclusiveTimeTest {
    private final ExclusiveTime et = new ExclusiveTime();
    private List<String> logs;

    @Test
    public void sampleInput1() {
        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        assertArrayEquals(new int[]{8}, et.exclusiveTime(1, logs));
    }

    @Test
    public void sampleInput2() {
        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
        assertArrayEquals(new int[]{7, 1}, et.exclusiveTime(2, logs));
    }
}

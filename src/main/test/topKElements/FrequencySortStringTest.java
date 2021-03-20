package topKElements;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrequencySortStringTest {
    private FrequencySortString sorter = new FrequencySortString();

    @Test
    public void sampleInput1() {
        assertEquals("bbbaac", sorter.transform("abcbba"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("ssssiiiippm", sorter.transform("mississippi"));
    }
}

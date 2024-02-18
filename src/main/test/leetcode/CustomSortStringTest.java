package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomSortStringTest {
    private final CustomSortString sort = new CustomSortString();

    @Test
    public void sampleInput1() {
        assertEquals("cbad", sort.customSortString("cba", "abcd"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("cbad", sort.customSortString("cbafg", "abcd"));
    }
}

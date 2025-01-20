package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostVisitedPageSequenceTest {
    private final MostVisitedPageSequence mostVisitedPageSequence = new MostVisitedPageSequence();

    private List<String> pages = List.of(
            "10:10:01 1001 A",
            "10:10:02 1001 B",
            "10:10:03 1001 C",
            "10:10:04 1002 E",
            "10:10:05 1001 D",
            "10:10:06 1001 E",
            "10:10:07 1002 B",
            "10:10:08 1002 C",
            "10:10:09 1002 D",
            "10:10:10 1002 A");

    @Test
    public void sampleInput1() {
        assertEquals("BCD", mostVisitedPageSequence.findMaxSequence(pages));
    }
}

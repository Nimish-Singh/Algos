package topKElements;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KMostFrequentElementsTest {
    private KMostFrequentElements frequentElements = new KMostFrequentElements();

    @Test
    public void sampleInput1() {
        List<Integer> elements = frequentElements.find(new int[]{1, 3, 5, 12, 11, 12, 1}, 2);
        assertEquals(2, elements.size());
        assertTrue(elements.contains(1));
        assertTrue(elements.contains(12));
    }
}

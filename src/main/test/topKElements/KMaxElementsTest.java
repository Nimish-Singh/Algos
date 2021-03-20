package topKElements;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KMaxElementsTest {
    private KMaxElements kMaxElements = new KMaxElements();

    @Test
    public void sampleInput1() {
        List<Integer> elements = Arrays.stream(kMaxElements.find(new int[]{3, 1, 5, 12, 2, 11}, 3))
                .boxed()
                .collect(Collectors.toList());
        assertTrue(elements.contains(5));
        assertTrue(elements.contains(11));
        assertTrue(elements.contains(12));
    }

    @Test
    public void sampleInput2() {
        List<Integer> elements = Arrays.stream(kMaxElements.find(new int[]{12, 5, 12, -1, 11}, 3))
                .boxed()
                .collect(Collectors.toList());
        assertEquals(2, Collections.frequency(elements, 12));
        assertTrue(elements.contains(11));
    }
}

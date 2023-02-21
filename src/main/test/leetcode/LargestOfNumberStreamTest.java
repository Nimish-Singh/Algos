package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LargestOfNumberStreamTest {
    private final LargestOfNumberStream largest = new LargestOfNumberStream();

    @Test
    public void shouldReturnNthLargestElement() throws Exception {
        largest.generateNum(6);
        largest.generateNum(4);
        largest.generateNum(0);
        assertThrows(Exception.class, largest::getNthLargest);

        largest.generateNum(-1);
        assertThrows(Exception.class, largest::getNthLargest);

        largest.generateNum(99);
        assertEquals(-1, largest.getNthLargest());
    }

    @Test
    public void shouldReturnMaxElement() {
        assertEquals(Integer.MIN_VALUE, largest.getMax());
        largest.generateNum(6);
        largest.generateNum(4);
        largest.generateNum(0);
        assertEquals(6, largest.getMax());

        largest.generateNum(-1);
        assertEquals(6, largest.getMax());

        largest.generateNum(99);
        assertEquals(99, largest.getMax());
    }

    @Test
    public void shouldReturnKthLargestInLastNElement() throws Exception {
        largest.generateNum(2);
        largest.generateNum(3);
        assertThrows(Exception.class, () -> largest.getKthLargestInLastNNumbers(3));

        largest.generateNum(4);
        largest.generateNum(6);
        assertThrows(Exception.class, () -> largest.getKthLargestInLastNNumbers(3));

        largest.generateNum(1);
        assertEquals(3, largest.getKthLargestInLastNNumbers(3));
        largest.generateNum(3);
        assertEquals(3, largest.getKthLargestInLastNNumbers(3));
        largest.generateNum(1);
        assertEquals(3, largest.getKthLargestInLastNNumbers(3));
        largest.generateNum(5);
        assertEquals(3, largest.getKthLargestInLastNNumbers(3));
        largest.generateNum(7);
        assertEquals(3, largest.getKthLargestInLastNNumbers(3));
        largest.generateNum(2);
        assertEquals(3, largest.getKthLargestInLastNNumbers(3));
        largest.generateNum(8);
        assertEquals(5, largest.getKthLargestInLastNNumbers(3));
    }
}
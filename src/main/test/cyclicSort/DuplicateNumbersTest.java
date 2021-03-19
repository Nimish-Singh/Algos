package cyclicSort;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DuplicateNumbersTest {
    private DuplicateNumbers duplicateNumbers = new DuplicateNumbers();

    @Test
    public void sampleInput1() {
        List<Integer> duplicates = duplicateNumbers.duplicateNumbers(new int[]{3, 4, 4, 5, 5});
        assertEquals(2, duplicates.size());
        assertTrue(duplicates.contains(4));
        assertTrue(duplicates.contains(5));
    }

    @Test
    public void sampleInput2() {
        List<Integer> duplicates = duplicateNumbers.duplicateNumbers(new int[]{5, 4, 7, 2, 3, 5, 3});
        assertEquals(2, duplicates.size());
        assertTrue(duplicates.contains(3));
        assertTrue(duplicates.contains(5));
    }
}

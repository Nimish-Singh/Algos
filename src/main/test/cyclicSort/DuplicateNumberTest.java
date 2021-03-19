package cyclicSort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateNumberTest {
    private DuplicateNumber duplicateNumber = new DuplicateNumber();

    @Test
    public void sampleInput1() {
        assertEquals(4, duplicateNumber.duplicateNumber(new int[]{1, 4, 4, 3, 2}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, duplicateNumber.duplicateNumber(new int[]{2, 1, 3, 3, 5, 4}));
    }

    @Test
    public void sampleInput3() {
        assertEquals(4, duplicateNumber.duplicateNumber(new int[]{2, 4, 1, 4, 4}));
    }
}

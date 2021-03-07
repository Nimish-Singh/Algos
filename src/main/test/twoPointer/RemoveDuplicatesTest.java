package twoPointer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesTest {
    private RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @Test
    public void sampleInput1() {
        assertEquals(4, removeDuplicates.remove(new int[] {2, 3, 3, 3, 6, 9, 9}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, removeDuplicates.remove(new int[] {2, 2, 2, 11}));
    }
}

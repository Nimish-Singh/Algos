package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementOccurenceTest {
    private ElementOccurence elementOccurence = new ElementOccurence();

    @Test
    public void shouldReturnZeroArrayIsNull() {
        assertEquals(0, elementOccurence.count(null, 6));
    }

    @Test
    public void shouldReturnZeroArrayIsEmpty() {
        assertEquals(0, elementOccurence.count(new int[]{}, 6));
    }

    @Test
    public void shouldReturnZeroIfElementNotPresentInArray() {
        assertEquals(0, elementOccurence.count(new int[]{1, 2, 3}, 6));
    }

    @Test
    public void shouldReturnCorrectCountIfElementPresentInFirstHalfOfArray() {
        assertEquals(3, elementOccurence.count(new int[]{1, 2, 2, 2, 3, 3, 4, 5, 7, 8}, 2));
    }

    @Test
    public void shouldReturnCorrectCountIfElementPresentInSecondHalfOfArray() {
        assertEquals(4, elementOccurence.count(new int[]{1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 7, 8}, 5));
    }

    @Test
    public void shouldReturnCorrectCountIfElementPresentInBothHalvesOfArray() {
        assertEquals(4, elementOccurence.count(new int[]{1, 2, 4, 4, 4, 4, 7}, 4));
    }
}

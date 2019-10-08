package sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HeapsortTest {
    private Heapsort heapsort = new Heapsort();

    @Test
    public void shouldSortArrayOfSize1() {
        int[] array = {5};
        int[] sortedArray = heapsort.sort(array, array.length);
        assertEquals(5, sortedArray[0]);
    }

    @Test
    public void shouldSortArrayOfSize2() {
        int[] array = {5, -6};
        int[] expectedArray = {-6, 5};
        int[] actualArray = heapsort.sort(array, array.length);
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldSortArrayOfSizeGreaterThan2() {
        int[] array = {5, -6, 9, 0, -2, -3, 1, -6};
        int[] expectedArray = {-6, -6, -3, -2, 0, 1, 5, 9};
        int[] actualArray = heapsort.sort(array, array.length);
        assertArrayEquals(expectedArray, actualArray);
    }
}
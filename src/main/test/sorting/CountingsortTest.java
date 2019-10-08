package sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class CountingsortTest {
    private Countingsort countingsort = new Countingsort();

    @Test
    public void shouldSortArrayOfSize1() {
        int[] array = {5};
        int[] sortedArray = countingsort.sort(array, getMaxElement(array));
        assertEquals(5, sortedArray[0]);
    }

    @Test
    public void shouldSortArrayOfSize2() {
        int[] array = {5, 6};
        int[] expectedArray = {5, 6};
        int[] actualArray = countingsort.sort(array, getMaxElement(array));
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldSortArrayOfSizeGreaterThan2() {
        int[] array = {5, 6, 9, 0, 2, 3, 1, 6};
        int[] expectedArray = {0, 1, 2, 3, 5, 6, 6, 9};
        int[] actualArray = countingsort.sort(array, getMaxElement(array));
        assertArrayEquals(expectedArray, actualArray);
    }

    private int getMaxElement(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }
}
package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrumpyBookstoreOwnerTest {
    private final GrumpyBookstoreOwner grumpyBookstoreOwner = new GrumpyBookstoreOwner();
    private int[] customers;
    private int[] grumpy;

    @Test
    public void sampleInput1() {
        customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        assertEquals(16, grumpyBookstoreOwner.maxSatisfied(customers, grumpy, 3));
    }

    @Test
    public void sampleInput2() {
        customers = new int[]{1};
        grumpy = new int[]{0};
        assertEquals(1, grumpyBookstoreOwner.maxSatisfied(customers, grumpy, 1));
    }

    @Test
    public void sampleInput3() {
        customers = new int[]{4, 10, 10};
        grumpy = new int[]{1, 1, 0};
        assertEquals(24, grumpyBookstoreOwner.maxSatisfied(customers, grumpy, 2));
    }
}

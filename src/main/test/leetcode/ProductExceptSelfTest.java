package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductExceptSelfTest {
    private ProductExceptSelf product = new ProductExceptSelf();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 3, 4};
        assertArrayEquals(new int[]{24, 12, 8, 6}, product.productExceptSelf(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{-1, 1, 0, -3, 3};
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, product.productExceptSelf(nums));
    }
}

package leetcode;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        products[0] = 1;

        // collect products until all elements to the left of current element
        for (int index = 1; index < nums.length; index++)
            products[index] = products[index - 1] * nums[index - 1];

        // include product of all elements to the right of the current element
        int runningProduct = nums[nums.length - 1];
        for (int index = nums.length - 2; index >= 0; index--) {
            products[index] = products[index] * runningProduct;
            runningProduct *= nums[index];
        }

        return products;
    }
}

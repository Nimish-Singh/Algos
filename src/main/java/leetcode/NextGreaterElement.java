package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    // https://leetcode.com/problems/next-greater-element-i/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek())
                nextGreaterMap.put(stack.pop(), num);
            stack.push(num);
        }

        return Arrays.stream(nums1)
                .map(num -> nextGreaterMap.getOrDefault(num, -1))
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // https://leetcode.com/problems/next-greater-element-ii/
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int index = nums.length - 1; index >= 0; index--) {
            stack.push(nums[index]);
        }

        int[] result = new int[nums.length];

        for (int index = nums.length - 1; index >= 0; index--) {
            result[index] = -1;
            while (!stack.isEmpty() && stack.peek() <= nums[index])
                stack.pop();
            if (!stack.isEmpty())
                result[index] = stack.peek();
            stack.push(nums[index]);
        }
        return result;
    }
}

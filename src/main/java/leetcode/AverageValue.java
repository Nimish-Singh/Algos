package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
public class AverageValue {
    public int averageValue(int[] nums) {
        double average = Arrays.stream(nums)
                .filter(n -> n % 6 == 0)
                .average()
                .orElse(0);
        return (int) average;
    }
}

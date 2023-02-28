package leetcode;

// https://leetcode.com/problems/find-the-array-concatenation-value/description/
public class ArrayConcatenationValue {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0, right = nums.length - 1;
        long answer = 0;

        while (left < right) {
            String concatenation = String.valueOf(nums[left]) + String.valueOf(nums[right]);
            answer += Long.parseLong(concatenation);
            left++; right--;
        }

        if (left == right) {
            answer += nums[left];
        }
        return answer;
    }
}

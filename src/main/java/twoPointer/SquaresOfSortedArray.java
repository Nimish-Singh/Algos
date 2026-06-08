package twoPointer;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};

        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }

        // Can be done even easier by starting at both extremes of array and filling the greater one into the end of answer array
        int negIndex = findNegIndex(nums);
        int posIndex = negIndex + 1;

        int[] answer = new int[nums.length];
        int answerIndex = 0;
        while (negIndex >= 0 && posIndex < nums.length) {
            if (nums[posIndex] < nums[negIndex] * -1) {
                answer[answerIndex] = nums[posIndex] * nums[posIndex];
                posIndex++;
            } else {
                answer[answerIndex] = nums[negIndex] * nums[negIndex];
                negIndex--;
            }
            answerIndex++;
        }

        while (negIndex >= 0) {
            answer[answerIndex++] = nums[negIndex] * nums[negIndex];
            negIndex--;
        }

        while (posIndex < nums.length) {
            answer[answerIndex++] = nums[posIndex] * nums[posIndex];
            posIndex++;
        }

        return answer;
    }

    private int findNegIndex(int[] nums) {
        if (nums[0] >= 0)
            return -1;

        if (nums[nums.length - 1] < 0)
            return nums.length - 1;

        int index = 0;
        while (nums[index] < 0)
            index++;

        return index - 1;
    }
}

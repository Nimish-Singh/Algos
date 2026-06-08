package twoPointer;

// https://leetcode.com/problems/move-zeroes
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int writeIndex = 0, readIndex;

        while (writeIndex < nums.length && nums[writeIndex] != 0)
            writeIndex++;

        readIndex = writeIndex + 1;
        while (readIndex < nums.length) {

            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                nums[readIndex] = 0;

                while (nums[writeIndex] != 0) {
                    writeIndex++;
                }
            } else {
                readIndex++;
            }
        }
    }
}

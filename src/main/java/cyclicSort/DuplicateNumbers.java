package cyclicSort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// Important
// Given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’ with some duplicates,
// find all the duplicate numbers without using any extra space.
public class DuplicateNumbers {
    public List<Integer> duplicateNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swapForIndices(nums, i, nums[i] - 1);
            else
                ++i;
        }

        return IntStream.range(0, nums.length)
                .filter(index -> nums[index] != index + 1)
                .map(index -> nums[index])
                .boxed()
                .collect(Collectors.toList());
    }

    private void swapForIndices(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

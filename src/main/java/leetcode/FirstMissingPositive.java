package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;

//        return minHeapApproach(nums);

//        return sortingApproach(nums);

        return linearApproach(nums);
    }

    // https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation (math magic)
    // T=O(n). S=O(1)

    private int linearApproach(int[] nums) {
        // answer will always be in range of [1, length + 1]
        int length = nums.length;
        for (int index = 0; index < length; index++) {
            // discard numbers <= 0 and numbers > length by marking them with a number greather than length
            if (nums[index] <= 0 || nums[index] > length)
                nums[index] = length + 1;
        }

        // mark numbers which are present in range [1, length + 1]
        for (int index = 0; index < length; index++) {
            // because there is a chance that this number has been minus'ed
            int element = Math.abs(nums[index]);
            // ignore elements as from line-24
            if (element > length)
                continue;

            // index 0 is mapped to element 1. Index i -> element (i+1)
            element--;
            // mark that specific number in array, which is accessible with this index, as minus (ie., seen)
            // we will make use of index to identify missing smallest element
            if (nums[element] > 0)
                nums[element] *= -1;
        }

        // the first index whose number is not seen, is the answer
        for (int index = 0; index < length; index++) {
            if (nums[index] > 0)
                return index + 1;
        }
        // else, the maximum possible answer
        return length + 1;
    }

    // T=O(nlogn). S=O(1)
    private int sortingApproach(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int smallest = 1;
        int index = 0;
        while (index < length && nums[index] <= 0)
            index++;

        while (index < length) {
            if (nums[index] == smallest)
                smallest++;
            index++;
        }
        return smallest;
    }

    // T=O(nlogn). S=O(n)
    private int minHeapApproach(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int num : nums) {
            if (num > 0)
                minHeap.offer(num);
        }

        int smallest = 1;
        while (!minHeap.isEmpty()) {
            Integer element = minHeap.poll();
            if (smallest < element)
                return smallest;

            smallest = element + 1;
        }
        return smallest;
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/sum-of-distances/description/
public class SumOfDistances {
    public long[] distance(int[] nums) {
        Map<Integer, long[]> elementIndexMap = new HashMap<>();
        /*
        long[0]: sum of left indices
        long[1]: sum of right indices
        long[2]: left frequency
        long[3]: right frequency
         */

        for (int index = 0; index < nums.length; index++) {
            if (!elementIndexMap.containsKey(nums[index])) {
                elementIndexMap.put(nums[index], new long[4]);
            }

            long[] arr = elementIndexMap.get(nums[index]);
            arr[1] += index;
            arr[3]++;
        }

        long[] answer = new long[nums.length];

        for (int index = 0; index < nums.length; index++) {
            long[] arr = elementIndexMap.get(nums[index]);
            answer[index] = ((arr[2] * index - arr[0]) + (arr[1] - arr[3] * index));
            arr[0] += index;
            arr[1] -= index;
            arr[2]++;
            arr[3]--;
        }

        return answer;
    }
}
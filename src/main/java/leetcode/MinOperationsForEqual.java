package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/description/
public class MinOperationsForEqual {
    // https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/solutions/3341928/c-java-python3-prefix-sums-binary-search/
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> answer = new ArrayList<>(queries.length);
        Arrays.sort(nums);

        int numsSize = nums.length;
        long[] prefixSum = new long[numsSize + 1];

        for (int index = 1; index <= numsSize; index++) {
            prefixSum[index] = prefixSum[index - 1] + nums[index - 1];
        }

        for (int query : queries) {
            int indexOfQueryElement = Arrays.binarySearch(nums, query);
            if (indexOfQueryElement < 0) {
                indexOfQueryElement = -(indexOfQueryElement + 1);
            }

            answer.add(1L * query * (2 * indexOfQueryElement - numsSize) + prefixSum[numsSize] - 2 * prefixSum[indexOfQueryElement]);
        }
        return answer;
    }
}

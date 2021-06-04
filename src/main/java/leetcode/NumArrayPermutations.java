package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Important
// https://leetcode.com/problems/permutations/
public class NumArrayPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        collectPermutations(nums, permutations, new ArrayList<>());
        return permutations;
    }

    private void collectPermutations(int[] nums, List<List<Integer>> finalPermutations, List<Integer> answerSoFar) {
        if (nums.length == 0) {
            finalPermutations.add(new ArrayList<>(answerSoFar));
            return;
        }

        for (int currentNum : nums) {
            List<Integer> permutation = new ArrayList<>(answerSoFar);
            permutation.add(currentNum);
            int[] remainingNums = Arrays.stream(nums).filter(num -> num != currentNum).toArray();
            collectPermutations(remainingNums, finalPermutations, permutation);
        }
    }
}

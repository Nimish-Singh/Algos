package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return Collections.emptyList();

        List<List<Integer>> combinations = new ArrayList<>();
        helper(candidates, target, combinations, new ArrayList<>(), 0);
        return combinations;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combinationSofar, int index) {
        if (target < 0)
            return;

        if (target == 0)
            combinations.add(new ArrayList<>(combinationSofar));

        for (int i = index; i < candidates.length; i++) {
            combinationSofar.add(candidates[i]);
            helper(candidates, target - candidates[i], combinations, combinationSofar, i);
            combinationSofar.remove(combinationSofar.size() - 1);
        }
    }
}

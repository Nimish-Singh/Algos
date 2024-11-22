package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(answer, new ArrayList<>(), k, n, 1);
        return answer;
    }

    private void helper(List<List<Integer>> answer, List<Integer> comboSoFar, int k, int sum, int numToConsider) {
        if (sum == 0 && comboSoFar.size() == k) {
            answer.add(new ArrayList<>(comboSoFar));
            return;
        }

        if ((sum > 0 && comboSoFar.size() >= k) || numToConsider > sum)
            return;

        for (int i = numToConsider; i <= 9; i++) {
            comboSoFar.add(i);
            helper(answer, comboSoFar, k, sum - i, i + 1);
            comboSoFar.removeLast();
        }
    }
}

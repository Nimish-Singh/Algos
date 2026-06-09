package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/minimum-absolute-difference/description/
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> answer = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);

            if (diff > minDiff)
                continue;

            if (diff == minDiff) {
                answer.add(List.of(arr[i], arr[i + 1]));
                continue;
            }

            answer.clear();
            minDiff = diff;
            answer.add(List.of(arr[i], arr[i + 1]));
        }

        return answer;
    }
}

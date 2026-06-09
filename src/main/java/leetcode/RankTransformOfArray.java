package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/rank-transform-of-an-array/description/
public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> rankMap = new HashMap<>();

        int[] sortedCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedCopy);

        int rank = 1;
        for (int num : sortedCopy) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = rankMap.get(arr[i]);
        }

        return answer;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[][] indexes = new int[26][2];
        for (int[] row : indexes)
            Arrays.fill(row, -1);

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (indexes[idx][0] == -1)
                indexes[idx][0] = i;
            else
                indexes[idx][1] = i;
        }

        Arrays.sort(indexes, (a, b) -> a[0] - b[0]);

        int arrayIdx = 0;
        while (indexes[arrayIdx][0] == -1)
            arrayIdx++;

        List<int[]> intervals = new ArrayList<>();
        intervals.add(indexes[arrayIdx++]);
        int listIdx = 0;

        int prevEnd = intervals.get(0)[1];
        while(arrayIdx < indexes.length) {
            if (prevEnd > indexes[arrayIdx][0]) {
                intervals.get(listIdx)[1] = Math.max(intervals.get(listIdx)[1], indexes[arrayIdx][1]);
                prevEnd = Math.max(intervals.get(listIdx)[1], indexes[arrayIdx][1]);
            } else {
                intervals.add(indexes[arrayIdx]);
                prevEnd = indexes[arrayIdx][1];
                listIdx++;
            }
            arrayIdx++;
        }

        List<Integer> answer = new LinkedList<>();
        for (int[] interval : intervals) {
            // for cases where we had only a single occurrence of a letter- in which case the end will still be -1
            int end = interval[1] == -1 ? interval[0] : interval[1];
            answer.add(end - interval[0] + 1);
        }

        return answer;
    }
}

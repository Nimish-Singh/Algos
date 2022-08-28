package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/queue-reconstruction-by-height/
public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> temp = new ArrayList<>(people.length);
        for (int[] person : people) {
            temp.add(person[1], person);
        }

        int[][] answer = new int[people.length][];
        int index = 0;
        for (int[] person : temp) {
            answer[index++] = person;
        }
        return answer;
    }
}

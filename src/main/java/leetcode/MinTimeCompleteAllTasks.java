package leetcode;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/minimum-time-to-complete-all-tasks/description/
public class MinTimeCompleteAllTasks {
    // https://leetcode.com/problems/minimum-time-to-complete-all-tasks/solutions/3287586/simple-diagram-explanation/
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t[1]));

        boolean[] visited = new boolean[2001];
        int answer = 0;

        for (int[] task : tasks) {
            int coincidingSeconds = 0;
            for (int time = task[0]; time <= task[1]; time++) {
                if (visited[time]) {
                    coincidingSeconds++;
                }
            }

            int endTime = task[1];
            while (coincidingSeconds < task[2]) {
                if (!visited[endTime]) {
                    answer++;
                    coincidingSeconds++;
                    visited[endTime] = true;
                }
                endTime--;
            }
        }
        return answer;
    }
}

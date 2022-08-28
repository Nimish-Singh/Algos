package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        Map<Character, Integer> taskFrequencies = new HashMap<>();
        for (char task : tasks) {
            taskFrequencies.put(task, taskFrequencies.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Character> maxFrequencyQueue = new PriorityQueue<>((a, b) -> taskFrequencies.get(a).equals(taskFrequencies.get(b)) ? a - b : taskFrequencies.get(b) - taskFrequencies.get(a));
        maxFrequencyQueue.addAll(taskFrequencies.keySet());

        int totalTime = 0;

        while (!maxFrequencyQueue.isEmpty()) {
            int cycle = n + 1;
            List<Character> currentTasks = new ArrayList<>(cycle);
            while (cycle > 0 && !maxFrequencyQueue.isEmpty()) {
                Character taskSelected = maxFrequencyQueue.poll();
                currentTasks.add(taskSelected);
                taskFrequencies.put(taskSelected, taskFrequencies.get(taskSelected) - 1);
                totalTime++;
                cycle--;
            }

            for (Character task : currentTasks) {
                if (taskFrequencies.get(task) > 0)
                    maxFrequencyQueue.offer(task);
            }

            if (maxFrequencyQueue.isEmpty()) break;;

            totalTime += cycle;
        }
        return totalTime;
    }
}

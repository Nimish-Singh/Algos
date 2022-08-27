package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// Important
// https://leetcode.com/problems/process-tasks-using-servers/
public class ProcessTasks {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] serverFreeTimes = new int[servers.length];
        int[] answer = new int[tasks.length];

        PriorityQueue<Integer> availableServers = new PriorityQueue<>((a, b) -> servers[a] == servers[b] ? a - b : servers[a] - servers[b]);
        for (int index = 0; index < servers.length; index++) {
            availableServers.offer(index);
        }

        PriorityQueue<Integer> occupiedServers = new PriorityQueue<>((a, b) -> serverFreeTimes[a] == serverFreeTimes[b] ? (servers[a] == servers[b] ? a - b : servers[a] - servers[b]) : serverFreeTimes[a] - serverFreeTimes[b]);

        for (int index = 0; index < tasks.length; index++) {
            while (occupiedServers.peek() != null && serverFreeTimes[occupiedServers.peek()] <= index) {
                availableServers.offer(occupiedServers.poll());
            }

            Integer assignedServer = availableServers.poll();
            if (assignedServer == null) {
                Integer nextAvailableServer = occupiedServers.poll();
                answer[index] = nextAvailableServer;
                serverFreeTimes[nextAvailableServer] += tasks[index];
                occupiedServers.offer(nextAvailableServer);
                continue;
            }

            serverFreeTimes[assignedServer] = index + tasks[index];
            answer[index] = assignedServer;
            occupiedServers.offer(assignedServer);
        }
        return answer;
    }
}

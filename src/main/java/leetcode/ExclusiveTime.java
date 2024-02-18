package leetcode;

import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/exclusive-time-of-functions/description/
public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] answer = new int[n];
        Stack<Log> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            Log l = new Log(log.split(":"));

            if (l.isStart) {
                if (!stack.isEmpty()) {
                    Log prevL = stack.peek();
                    answer[prevL.id] += l.time - prevTime;
                }
                prevTime = l.time;
                stack.push(l);
            } else {
                answer[l.id] += l.time - prevTime + 1;
                prevTime = l.time + 1;
                stack.pop();
            }
        }

        return answer;
    }

    class Log {
        int id;
        boolean isStart;
        int time;

        Log(String[] line) {
            id = Integer.parseInt(line[0]);
            isStart = line[1].equals("start");
            time = Integer.parseInt(line[2]);
        }
    }
}

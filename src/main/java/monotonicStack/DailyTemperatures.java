package monotonicStack;

import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();

        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                Integer top = s.pop();
                answer[top] = i - top;
            }

            s.push(i);
        }

        return answer;
    }
}

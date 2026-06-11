package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
public class RemoveAllAdjacentDuplicates2 {
    public String removeDuplicates(String s, int k) {
        Stack<FreqPair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.push(new FreqPair(c, 1));
                continue;
            }

           stack.peek().freq++;

            if (stack.peek().freq == k)
                stack.pop();
        }

        StringBuilder answer = new StringBuilder("");

        while (!stack.isEmpty()) {
            FreqPair top = stack.pop();

            for (int i = 0; i < top.freq; i++)
                answer.append(top.c);

        }

        return answer.reverse().toString();
    }

    private class FreqPair {
        char c;
        int freq;

        public FreqPair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}

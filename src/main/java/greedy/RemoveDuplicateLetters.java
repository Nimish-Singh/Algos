package greedy;

import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];

        for (char character: s.toCharArray()) {
            count[character - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] alreadyInStack = new boolean[26];

        for (char character : s.toCharArray()) {
            count[character - 'a']--;

            if (alreadyInStack[character - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > character && count[stack.peek() - 'a'] != 0) {
                alreadyInStack[stack.pop() - 'a'] = false;
            }
            stack.push(character);
            alreadyInStack[character - 'a'] = true;
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }
}

package leetcode;

import dynamicProgramming.PalindromicSubstrings;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return s;

//        return recursive(s, k);

        return iterative(s, k);
    }

    private String iterative(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!charStack.isEmpty() && charStack.peek() == ch)
                countStack.push(countStack.peek() + 1);
            else
                countStack.push(1);
            charStack.push(ch);

            if (countStack.peek() == k) {
                for (int i = 0; i < k; i++) {
                    charStack.pop();
                    countStack.pop();
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!charStack.isEmpty())
            answer.append(charStack.pop());

        return answer.reverse().toString();
    }

    // Gave TLE, possibly because of recursion overhead. Approach is right
    private String recursive(String s, int k) {
        int count = 1;
        for (int index = 1; index < s.length(); index++) {
            if (s.charAt(index) == s.charAt(index - 1))
                count++;
            else
                count = 1;

            if (count == k) {
                return recursive(s.substring(0, index - k + 1) + s.substring(index + 1), k);
            }
        }

        return s;
    }
}

package greedy;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if ("".equals(num) || num.length() <= k)
            return "0";

        Stack<Character> stack = new Stack<>();

        for (Character character : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > character) {
                stack.pop();
                k--;
            }
            stack.push(character);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        int index = 0;
        for (; index < result.length(); index++) {
            if (result.charAt(index) != '0')
                break;
        }

        return result.substring(index).equals("") ? "0" : result.substring(index);
    }
}

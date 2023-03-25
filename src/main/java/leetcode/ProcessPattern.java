package leetcode;

import java.util.Stack;

/*
Given a pattern which can include numbers, brackets and alphabets, return a string which is repeated as many times as
given in the pattern. Eg-
a2{b2{c1}}12{x} should return abc1c1bc1c1xxxxxxxxxxxx
 */
public class ProcessPattern {
    public String processInput(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        Stack<String> charStack = new Stack<>();
        Stack<Integer> frequencyStack = new Stack<>();
        char[] inputArr = input.toCharArray();
        for (char c : inputArr) {
            // handle { case
            if (c == '{') {
                String num = "";
                while (!charStack.isEmpty() && Character.isDigit(charStack.peek().charAt(0))) {
                    num = charStack.pop() + num;
                }
                if (!"".equals(num)) {
                    frequencyStack.push(Integer.parseInt(num));
                }
                charStack.push(String.valueOf(c));
                continue;
            }

            // handle } case
            if (c == '}') {
                String repeat = "";
                while (!charStack.isEmpty() && !charStack.peek().equals("{")) {
                    repeat = charStack.pop() + repeat;
                }
                if (!charStack.isEmpty()) {
                    charStack.pop();
                }
                int repeatTimes = frequencyStack.peek() == null ? 1 : frequencyStack.pop();
                String repeatedPattern = repeat.repeat(repeatTimes);
                charStack.push(repeatedPattern);
                continue;
            }

            // in everything else, just push
            charStack.push(String.valueOf(c));
        }

        String answer = "";
        while (!charStack.isEmpty()) {
            answer = charStack.pop() + answer;
        }
        return answer;
    }
}

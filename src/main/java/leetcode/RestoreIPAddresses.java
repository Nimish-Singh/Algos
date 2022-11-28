package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        helper(s, "", 0, answer);
        return answer;
    }

    private void helper(String input, String answerSoFar, int dotsAdded, List<String> answer) {
        if (dotsAdded == 4) {
            if ("".equals(input)) {
                String ipAddress = answerSoFar.substring(0, answerSoFar.length() - 1);
                answer.add(ipAddress);
            }
            return;
        }

        for (int numOfDigits = 1; numOfDigits <= 3; numOfDigits++) {
            if (input.length() < numOfDigits)
                continue;

            int number = Integer.parseInt(input.substring(0, numOfDigits));

            // Check for parsing where 010 would give 10 but numOfDigits = 3
            if (number > 255 || numOfDigits != String.valueOf(number).length())
                continue;

            helper(input.substring(numOfDigits), answerSoFar + input.substring(0, numOfDigits) + ".", dotsAdded + 1, answer);
        }
    }
}

package leetcode;

// https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String previousString = countAndSay(n - 1);

        StringBuilder answer = new StringBuilder();
        for (int startIndex = 0; startIndex < previousString.length();) {
            String digit = previousString.substring(startIndex, startIndex + 1);
            int endIndex = startIndex + 1;
            while (endIndex < previousString.length() && previousString.substring(endIndex, endIndex + 1).equals(digit))
                endIndex++;

            int count = endIndex - startIndex;
            answer.append(count).append(digit);
            startIndex = endIndex;
        }
        return answer.toString();
    }
}

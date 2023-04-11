package leetcode;

// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/description/
public class LongestBalancedBinarySubstring {
    public int findTheLongestBalancedSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0, answer = 0;
        while (index < s.length()) {
            int zeroCount = 0;
            while (index < s.length() && s.charAt(index) == '0') {
                zeroCount++;
                index++;
            }
            int oneCount = 0;
            while (index < s.length() && s.charAt(index) == '1') {
                oneCount++;
                index++;
            }
            answer = Math.max(answer, 2 * Math.min(zeroCount, oneCount));
        }
        return answer;
    }
}

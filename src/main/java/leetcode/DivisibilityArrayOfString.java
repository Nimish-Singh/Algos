package leetcode;

// https://leetcode.com/problems/find-the-divisibility-array-of-a-string/description/
public class DivisibilityArrayOfString {
    public int[] divisibilityArray(String word, int m) {
        int[] answer = new int[word.length()];
        long runningRemainder = 0;
        for (int index = 0; index < word.length(); index++) {
            runningRemainder = runningRemainder * 10 + (word.charAt(index) - '0');
            answer[index] = runningRemainder % m == 0 ? 1 : 0;
            runningRemainder = runningRemainder % m;
        }
        return answer;
    }
}

package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/mice-and-cheese/description/
public class MiceAndCheese {
    // https://leetcode.com/problems/mice-and-cheese/solutions/3368322/java-c-python-k-largest-a-i-b-i/
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int length = reward1.length;
        int[] differences = new int[length];
        int answer = 0;

        for (int index = 0; index < length; index++) {
            differences[index] = reward1[index] - reward2[index];
            answer += reward2[index];
        }

        Arrays.sort(differences);

        for (int counter = 0; counter < k; counter++) {
            answer += differences[length - 1 - counter];
        }

        return answer;
    }
}

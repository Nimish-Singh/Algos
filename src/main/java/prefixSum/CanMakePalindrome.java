package prefixSum;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/can-make-palindrome-from-substring/
public class CanMakePalindrome {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> output = new ArrayList<>();
        int[][] characterCount = new int[s.length() + 1][26];
        // count number of each character in each substring from 0 to index
        for (int index = 0; index < s.length(); ++index) {
            characterCount[index + 1] = characterCount[index].clone(); // copy previous sum.
            ++characterCount[index + 1][s.charAt(index) - 'a'];
        }
        for (int[] query : queries) {
            int oddCharacterCounts = 0;
            for (int index = 0; index < 26; ++index) {
                // count characters which have odd number of occurences
                oddCharacterCounts += (characterCount[query[1] + 1][index] - characterCount[query[0]][index]) % 2;
            }
            output.add(oddCharacterCounts / 2 <= query[2]);
        }
        return output;
    }
}

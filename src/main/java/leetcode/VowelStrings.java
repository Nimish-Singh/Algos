package leetcode;

// https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
public class VowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] answer = new int[words.length];
        answer[0] = isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length() - 1)) ? 1 : 0;

        for (int index = 1; index < answer.length; index++) {
            String word = words[index];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                answer[index] = answer[index - 1] + 1;
            } else {
                answer[index] = answer[index - 1];
            }
        }

        int[] result = new int[queries.length];


        for (int ans : answer) {
            System.out.print(ans + ", ");
        }

        for (int index = 0; index < queries.length; index++) {
            int toSubtract = queries[index][0] == 0 ? 0 : answer[queries[index][0] - 1];
            result[index] = answer[queries[index][1]] - toSubtract;
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

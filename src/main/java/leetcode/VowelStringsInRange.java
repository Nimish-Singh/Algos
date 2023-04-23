package leetcode;

// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/description/
public class VowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        if (left > words.length)
            return 0;

        int answer = 0;
        for (int index = left; index < words.length && index <= right; index++) {
            if (isVowelString(words[index])) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1)) ;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

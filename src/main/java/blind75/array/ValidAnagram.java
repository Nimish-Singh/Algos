package blind75.array;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counts = new int[26];

        for (char sChar : s.toCharArray()) {
            counts[sChar - 'a']++;
        }

        for (char tChar : t.toCharArray()) {
            if (counts[tChar - 'a'] == 0)
                return false;
            counts[tChar - 'a']--;
        }
        return true;
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

// https://leetcode.com/problems/bulls-and-cows/
public class BullsAndCows {
    public String getHint(String secret, String guess) {
//        return originalApproach(secret, guess);
        return optimisedApproach(secret, guess);
    }

    private String optimisedApproach(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];

        for (int index = 0; index < secret.length(); index++) {
            if (secret.charAt(index) == guess.charAt(index))
                bulls++;
            else {
                int secretDigit = Character.getNumericValue(secret.charAt(index));
                int guessDigit = Character.getNumericValue(guess.charAt(index));

                // Good approach for counting elements after "match" operation
                if (numbers[secretDigit] < 0)
                    cows++;
                if (numbers[guessDigit] > 0)
                    cows++;

                numbers[secretDigit]++;
                numbers[guessDigit]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    private String originalApproach(String secret, String guess) {
        Map<Character, SortedSet<Integer>> charIndexMap = new HashMap<>();

        char[] secretChars = secret.toCharArray();
        for (int index = 0; index < secretChars.length; index++) {
            char currentChar = secretChars[index];
            if (!charIndexMap.containsKey(currentChar)) {
                charIndexMap.put(currentChar, new TreeSet<>());
            }
            charIndexMap.get(currentChar).add(index);
        }

        int bulls = 0, cows = 0;
        boolean[] checked = new boolean[guess.length()]; // to avoid double counting

        char[] guessChars = guess.toCharArray();
        for (int index = 0; index < guess.length(); index++) {
            char currentChar = guessChars[index];
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar).contains(index)) {
                bulls++;
                checked[index] = true;
                charIndexMap.get(currentChar).remove(index);

                if (charIndexMap.get(currentChar).isEmpty())
                    charIndexMap.remove(currentChar);
            }
        }

        for (int index = 0; index < guess.length(); index++) {
            char currentChar = guessChars[index];
            if (!checked[index] && charIndexMap.containsKey(currentChar)) {
                cows++;
                Integer firstElement = charIndexMap.get(currentChar).first();
                charIndexMap.get(currentChar).remove(firstElement);

                if (charIndexMap.get(currentChar).isEmpty())
                    charIndexMap.remove(currentChar);
            }
        }

        return bulls + "A" + cows + "B";
    }
}

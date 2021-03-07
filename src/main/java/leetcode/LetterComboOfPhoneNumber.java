package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterComboOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return Collections.emptyList();

        if (digits.length() == 1)
            return digitToLetter(digits);

        List<String> lettersForFirstDigit = digitToLetter(digits.substring(0, 1));
        List<String> lettersForRestOfTheDigits = letterCombinations(digits.substring(1));
        List<String> finalCombinationList = new ArrayList<>();

        for (String firstLetter: lettersForFirstDigit) {
            for (String otherLetters : lettersForRestOfTheDigits) {
                finalCombinationList.add(firstLetter + otherLetters);
            }
        }
        return finalCombinationList;
    }

    private List<String> digitToLetter(String digit) {
        switch (digit) {
            case "2":
                return Arrays.asList("a", "b", "c");
            case "3":
                return Arrays.asList("d", "e", "f");
            case "4":
                return Arrays.asList("g", "h", "i");
            case "5":
                return Arrays.asList("j", "k", "l");
            case "6":
                return Arrays.asList("m", "n", "o");
            case "7":
                return Arrays.asList("p", "q", "r", "s");
            case "8":
                return Arrays.asList("t", "u", "v");
            case "9":
                return Arrays.asList("w", "x", "y", "z");
            default:
                return Collections.emptyList();
        }
    }
}

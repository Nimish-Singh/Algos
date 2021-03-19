package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Find all translations of a number, changing the digits to their corresponding letter in the alphabet, ex- 1 = a, 2 = b... 26 = z
public class NumberToAlphabetsCombo {
    public List<String> getCombinations(int number) {
        if (number == 0)
            return Collections.emptyList();

        if (number < 10)
            return Collections.singletonList(String.valueOf((char) (number + 96)));

        int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
        int secondDigit = Integer.parseInt(Integer.toString(number).substring(1, 2));
        List<String> totalCombos = new ArrayList<>();
        if (secondDigit != 0) {
            String firstDigitLetter = String.valueOf((char) (firstDigit + 96));
            totalCombos = getCombinations(Integer.parseInt(Integer.toString(number).substring(1)))
                    .stream()
                    .map(combo -> firstDigitLetter + combo)
                    .collect(Collectors.toList());
        }

        int firstTwoDigits = Integer.parseInt(Integer.toString(number).substring(0, 2));
        if (firstTwoDigits < 27) {
            String firstTwoDigitsLetter = String.valueOf((char) (firstTwoDigits + 96));
            List<String> combosWithTwoLettersExtracted = new ArrayList<>();
            if (number/100 > 0) {
                int restOfTheNumber = Integer.parseInt(Integer.toString(number).substring(2));
                combosWithTwoLettersExtracted = getCombinations(restOfTheNumber)
                        .stream()
                        .map(combo -> firstTwoDigitsLetter + combo)
                        .collect(Collectors.toList());
                totalCombos.addAll(combosWithTwoLettersExtracted);
            } else {
                totalCombos.add(firstTwoDigitsLetter);
            }
        }
        return totalCombos;
    }
}

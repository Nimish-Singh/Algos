package leetcode;

import java.util.ArrayList;
import java.util.List;

// Given a number in base -2 representation (with MSB and LSB order reversed), return the shortest sequence of bits that
// represent the ceiling of half of the number.
// Example- [1, 0, 0, 1, 1, 1] represents -23. The answer is [1, 0, 1, 0, 1, 1] ie., -11
public class ConvertToNegativeBase {
    public int[] solution(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }

        long number = getDecimalNumber(A);
        long requiredNumber = (long) Math.ceil((double) number / 2);

        return convertToBaseMinusTwo(requiredNumber);
    }

    private long getDecimalNumber(int[] baseMinusTwoRepresentation) {
        int base = -2;
        long decimal = 0;
        long numberToAdd = 1;

        for (int bit : baseMinusTwoRepresentation) {
            if (bit == 1)
                decimal += numberToAdd;
            numberToAdd *= base;
        }
        return decimal;
    }

    private int[] convertToBaseMinusTwo(long decimal) {
        if (decimal == 0) {
            return new int[]{0};
        }

        List<Integer> baseMinusTwoRepresentation = new ArrayList<>();
        int base = -2;

        while (decimal != 0) {
            int remainder = (int) decimal % base;
            decimal /= base;

            if (remainder < 0) {
                remainder -= base;
                decimal++;
            }

            baseMinusTwoRepresentation.add(remainder);
        }

        return baseMinusTwoRepresentation.stream()
            .mapToInt(num -> num)
            .toArray();
    }
}

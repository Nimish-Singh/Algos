package leetcode;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

// https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {
    public String intToRoman(int num) {
        SortedMap<Integer, String> symbolMap = new TreeMap<>((a, b) -> b - a);
        initialiseSymbolMap(symbolMap);
        Set<Integer> keys = symbolMap.keySet();
        StringBuilder romanRepresentation = new StringBuilder();
        while (num > 0) {
            int numCopy = num;
            Optional<Integer> largestReducibleNumber = keys.stream().filter(k -> numCopy - k >= 0).findFirst();
            romanRepresentation.append(symbolMap.get(largestReducibleNumber.get()));
            num -= largestReducibleNumber.get();
        }
        return romanRepresentation.toString();
    }

    private void initialiseSymbolMap(Map<Integer, String> symbolMap) {
        symbolMap.put(1, "I");
        symbolMap.put(5, "V");
        symbolMap.put(10, "X");
        symbolMap.put(50, "L");
        symbolMap.put(100, "C");
        symbolMap.put(500, "D");
        symbolMap.put(1000, "M");
        symbolMap.put(4, "IV");
        symbolMap.put(9, "IX");
        symbolMap.put(40, "XL");
        symbolMap.put(90, "XC");
        symbolMap.put(400, "CD");
        symbolMap.put(900, "CM");
    }
}

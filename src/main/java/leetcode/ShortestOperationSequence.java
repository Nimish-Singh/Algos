package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert from source
to targetthat uses the least edits possible.
For example, with strings source = "ABCDEFG", and target = "ABDFFGH" we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"]
More formally, for each character C in source, we will either write the token C, which does not count as an edit; or write the token -C, which counts as an edit.
Additionally, between any token that we write, we may write +D where D is any letter, which counts as an edit.
 */
public class ShortestOperationSequence {
    public String[] diffBetweenTwoStrings(String source, String target) {
//        List<String> sequenceList = recursiveApproach(source, 0, target, 0);
        int[][] minimumOperationCount = new int[source.length() + 1][target.length() + 1];
        for (int[] arr : minimumOperationCount) {
            Arrays.fill(arr, -1);
        }
        topDownDp(source, 0, target, 0, minimumOperationCount);
        List<String> sequenceList = constructSequenceFromMemo(source, target, minimumOperationCount);
        return sequenceList.toArray(new String[0]);
    }

    private int topDownDp(String source, int sourceIndex, String target, int targetIndex, int[][] memo) {
        if (memo[sourceIndex][targetIndex] != -1)
            return memo[sourceIndex][targetIndex];

        if (sourceIndex == source.length()) {
            memo[sourceIndex][targetIndex] = target.length() - targetIndex;
            return memo[sourceIndex][targetIndex];
        }

        if (targetIndex == target.length()) {
            memo[sourceIndex][targetIndex] = source.length() - sourceIndex;
            return memo[sourceIndex][targetIndex];
        }

        if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
            memo[sourceIndex][targetIndex] = topDownDp(source, sourceIndex + 1, target, targetIndex + 1, memo);
            return memo[sourceIndex][targetIndex];
        }

        memo[sourceIndex][targetIndex] = 1 + Math.min(topDownDp(source, sourceIndex + 1, target, targetIndex, memo),
                topDownDp(source, sourceIndex, target, targetIndex + 1, memo));

        return memo[sourceIndex][targetIndex];
    }

    private List<String> constructSequenceFromMemo(String source, String target, int[][] memo) {
        int sourceIndex = 0, targetIndex = 0;
        List<String> operations = new ArrayList<>();
        while (sourceIndex < source.length() && targetIndex < target.length()) {
            if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                operations.add(source.substring(sourceIndex, sourceIndex + 1));
                sourceIndex++;
                targetIndex++;
                continue;
            }

            if (memo[sourceIndex + 1][targetIndex] <= memo[sourceIndex][targetIndex + 1]) {
                operations.add("-" + source.charAt(sourceIndex));
                sourceIndex++;
            } else {
                operations.add("+" + target.charAt(targetIndex));
                targetIndex++;
            }
        }

        while (targetIndex < target.length()) {
            operations.add("+" + target.charAt(targetIndex));
            targetIndex++;
        }

        return operations;
    }

    private List<String> recursiveApproach(String source, int sourceIndex, String target, int targetIndex) {
        if (sourceIndex >= source.length()) {
            List<String> remainingChars = getAllRemainingCharactersAsList(target, targetIndex);
            remainingChars.replaceAll(s -> "+" + s);
            return remainingChars;
        }
        if (targetIndex >= target.length()) {
            List<String> extraChars = getAllRemainingCharactersAsList(source, sourceIndex);
            extraChars.replaceAll(s -> "-" + s);
            return extraChars;
        }

        if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
            List<String> operations = new ArrayList<>();
            operations.add(source.substring(sourceIndex, sourceIndex + 1));
            operations.addAll(recursiveApproach(source, sourceIndex + 1, target, targetIndex + 1));
            return operations;
        }

        List<String> operationsWhenUnequal = new ArrayList<>();
        List<String> operationsWhenThisRemoved = recursiveApproach(source, sourceIndex + 1, target, targetIndex);
        List<String> operationsWhenThisAdded = recursiveApproach(source, sourceIndex, target, targetIndex + 1);

        if (operationsWhenThisRemoved.size() <= operationsWhenThisAdded.size()) {
            operationsWhenUnequal.add("-" + source.charAt(sourceIndex));
            operationsWhenUnequal.addAll(operationsWhenThisRemoved);
        } else {
            operationsWhenUnequal.add("+" + target.charAt(targetIndex));
            operationsWhenUnequal.addAll(operationsWhenThisAdded);
        }
        return operationsWhenUnequal;
    }

    private List<String> getAllRemainingCharactersAsList(String string, int startIndex) {
        List<String> chars = new ArrayList<>();
        for (int index = startIndex; index < string.length(); index++) {
            chars.add(string.substring(index, index + 1));
        }
        return chars;
    }
}

package sorting;

import java.util.stream.IntStream;

class Countingsort {
    int[] sort(int[] array, int k) {
        int[] sortedArray = new int[array.length];

        int[] countingArray = IntStream.range(0, k + 1).map(i -> 0).toArray();
        IntStream.range(0, array.length).forEach(i -> countingArray[array[i]]++);
        IntStream.range(1, k + 1).forEach(i -> countingArray[i] = countingArray[i] + countingArray[i - 1]);

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countingArray[array[i]] - 1] = array[i];
            countingArray[array[i]]--;
        }

        return sortedArray;
    }
}

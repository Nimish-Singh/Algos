package sorting;

import static utils.IntegerUtils.swap;

class Quicksort {
    int[] sort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            array = sort(array, p, q);
            array = sort(array, q + 1, r);
        }
        return array;
    }

    private int partition(int[] array, int p, int r) {
        int x = array[r - 1];
        int i = p - 1;
        int j = p;

        while (j < r - 1) {
            if (array[j] <= x) {
                i++;
                array[j] = swap(array[i], array[i] = array[j]);
            }
            j++;
        }
        array[r - 1] = swap(array[i + 1], array[i + 1] = array[r - 1]);
        return ++i;
    }
}

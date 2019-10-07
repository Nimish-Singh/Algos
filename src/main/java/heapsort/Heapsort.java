package heapsort;

class Heapsort {
    private int heapSize;

    int[] sort(int[] array, int length) {
        buildMaxHeap(array, length);
        for (int i = length - 1; i >= 0; i--) {
            array[i] = swap(array[0], array[0] = array[i]);
            heapSize--;
            maxHeapify(array, 0);
        }
        return array;
    }

    private void buildMaxHeap(int[] array, int length) {
        heapSize = length;
        for (int i = length / 2; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    private void maxHeapify(int[] array, int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < heapSize && array[left] > array[i]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            array[largest] = swap(array[i], array[i] = array[largest]);
            maxHeapify(array, largest);
        }
    }

    private int swap(int i, int j) {
        return i;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}

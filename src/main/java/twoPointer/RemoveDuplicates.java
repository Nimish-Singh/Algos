package twoPointer;

// Remove duplicates from a sorted array
public class RemoveDuplicates {
    public int remove(int[] arr) {
        if (arr == null)
            return 0;
        if (arr.length < 2)
            return arr.length;
        int length = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                length++;
            }
        }
        return length;
    }
}

package twoPointer;

// Given a sorted array or numbers, return a new array with squares of the numbers, arranged in ascending order
public class SortedSquares {
    public int[] makeSquares(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int[] {};

        int low = 0, high = arr.length - 1, squaresIndex = high;
        int[] squareArray = new int[arr.length];

        while (low <= high) {
            if (Math.abs(arr[low]) > Math.abs(arr[high])) {
                squareArray[squaresIndex] = arr[low] * arr[low];
                low++;
            } else {
                squareArray[squaresIndex] = arr[high] * arr[high];
                high--;
            }
            squaresIndex--;
        }
        return squareArray;
    }
}

package leetcode;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchMatrix {
    // same idea, but implemented better here- https://leetcode.com/problems/search-a-2d-matrix/discuss/26279/Java-O(logM-%2B-logN)-solution
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        int rowToSearch = -1;

        if (target < matrix[0][0] || target > matrix[numberOfRows - 1][numberOfColumns - 1])
            return false;

        int mid = -1;

        // binary search to find the row no. to search in
        while (low <= high) {
            mid = (low + high) / 2;

            if (matrix[mid][numberOfColumns - 1] == target)
                return true;

            if (matrix[mid][numberOfColumns - 1] < target) {
                if (mid < numberOfRows - 1 && matrix[mid + 1][numberOfColumns - 1] > target) {
                    rowToSearch = mid + 1;
                    break;
                } else
                    low = mid + 1;
                continue;
            }

            if (mid > 0 && matrix[mid - 1][numberOfColumns - 1] < target) {
                rowToSearch = mid;
                break;
            } else
                high = mid - 1;
        }

        // likely case if element is in first or last row (or not present at all)
        if (rowToSearch == -1)
            rowToSearch = mid;

        low = 0;
        high = numberOfColumns - 1;

        // binary search to find the element in the designated row
        while (low <= high) {
            mid = (low + high) / 2;

            if (matrix[rowToSearch][mid] == target)
                return true;

            if (matrix[rowToSearch][mid] < target) {
                low = mid + 1;
                continue;
            }

            high = mid - 1;
        }

        return false;
    }

}

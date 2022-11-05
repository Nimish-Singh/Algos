package blind75.tree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum {
    private int answer;

    public int maxPathSum(TreeNode root) {
        answer = Integer.MIN_VALUE;
        findMaxSum(root);
        return answer;
    }

    // https://www.youtube.com/watch?v=JBYs5J4skZE and https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/389609/Full-Explanation-article-with-pseudo-code-Beats-JAVA-100-time-and-100-space-Solution
    private int findMaxSum(TreeNode root) {
        if (root == null)
            return 0;

        // Find max sum possible from each of left and right subtree
        int leftChildMax = findMaxSum(root.left);
        int rightChildMax = findMaxSum(root.right);

        // Find max of one of the subtrees
        int childrenMax = Math.max(leftChildMax, rightChildMax);

        // Max considering root OR root + left OR root + right. All these possibilities can be extended as longer paths in the upper level
        int maxConsideringRoot = Math.max(root.val, root.val + childrenMax);

        // Also considering 4th possibility: root + left + right. This path is fixed and can't be part of any other path
        int maxOfAllPossibilities = Math.max(maxConsideringRoot, root.val + leftChildMax + rightChildMax);

        answer = Math.max(answer, maxOfAllPossibilities);

        // For calculations, we can only consider paths where both left and right children are not considered, hence passing this value for those calculations.
        // However, updation of max happened before, considering all possible 4 paths
        return maxConsideringRoot;
    }
}


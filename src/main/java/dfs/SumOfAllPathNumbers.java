package dfs;

// Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will
// represent a number. Find the total sum of all the numbers represented by all paths
public class SumOfAllPathNumbers {
    public int find(Node root) {
        return helper(root, 0);
    }

    private int helper(Node root, int pathSum) {
        if (root == null)
            return 0;

        pathSum = pathSum * 10 + root.value;
        if (root.left == null && root.right == null)
            return pathSum;

        return helper(root.left, pathSum) + helper(root.right, pathSum);
    }
}

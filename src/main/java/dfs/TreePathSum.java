package dfs;

// Given a binary tree and a number 'S', find if the tree has a path from root-to-leaf such that
// the sum of all the node values of that path equals 'S'
public class TreePathSum {
    public boolean hasPath(Node root, int sum) {
        if (root == null && sum == 0)
            return true;
        if (root == null)
            return false;

        return hasPath(root.left, sum - root.value) || hasPath(root.right, sum - root.value);
    }
}

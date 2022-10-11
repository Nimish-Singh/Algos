package blind75.tree;

// https://leetcode.com/problems/subtree-of-another-tree/
public class Subtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        if (isIdentical(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical (TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }

        return root.val == subRoot.val && isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}

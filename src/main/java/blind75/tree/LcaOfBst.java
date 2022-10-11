package blind75.tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LcaOfBst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode smaller, larger;

        if (p.val <= q.val) {
            smaller = p;
            larger = q;
        } else {
            smaller = q;
            larger = p;
        }

        return findLcs(root, smaller, larger);
    }

    private TreeNode findLcs(TreeNode root, TreeNode smaller, TreeNode larger) {
        if (root == null)
            return null;

        if (root.val == smaller.val || root.val == larger.val)
            return root;

        if (root.val >= smaller.val && root.val <= larger.val)
            return root;

        if (root.val <= smaller.val)
            return findLcs(root.right, smaller, larger);

        return findLcs(root.left, smaller, larger);
    }
}

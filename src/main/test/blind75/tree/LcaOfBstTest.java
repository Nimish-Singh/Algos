package blind75.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LcaOfBstTest {
    private final LcaOfBst lcs = new LcaOfBst();
    private TreeNode bst;

    @Test
    public void sampleInput1() {
        bst = new TreeNode(6);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(8);
        bst.left.left = new TreeNode(0);
        bst.left.right = new TreeNode(4);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        bst.left.right.left = new TreeNode(3);
        bst.left.right.right = new TreeNode(5);

        assertEquals(6, lcs.lowestCommonAncestor(bst, bst.left, bst.right).val);
    }

    @Test
    public void sampleInput2() {
        bst = new TreeNode(6);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(8);
        bst.left.left = new TreeNode(0);
        bst.left.right = new TreeNode(4);
        bst.right.left = new TreeNode(7);
        bst.right.right = new TreeNode(9);
        bst.left.right.left = new TreeNode(3);
        bst.left.right.right = new TreeNode(5);

        assertEquals(2, lcs.lowestCommonAncestor(bst, bst.left, bst.left.right).val);
    }

    @Test
    public void sampleInput3() {
        bst = new TreeNode(2);
        bst.left = new TreeNode(1);

        assertEquals(2, lcs.lowestCommonAncestor(bst, bst, bst.left).val);
    }
}

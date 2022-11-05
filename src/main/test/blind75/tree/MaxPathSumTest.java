package blind75.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxPathSumTest {
    private final MaxPathSum max = new MaxPathSum();
    private TreeNode root;

    @Test
    public void sampleInput1() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertEquals(6, max.maxPathSum(root));
    }

    @Test
    public void sampleInput2() {
        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertEquals(42, max.maxPathSum(root));
    }

    @Test
    public void sampleInput3() {
        root = new TreeNode(1);
        root.left = new TreeNode(-3);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(12);
        root.left.right.right = new TreeNode(-3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(-6);
        root.right.right.left = new TreeNode(4);

        assertEquals(30, max.maxPathSum(root));
    }
}

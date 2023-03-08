package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestSumInBinaryTreeTest {
    private final KthLargestSumInBinaryTree kth = new KthLargestSumInBinaryTree();
    private TreeNode root;

    @Test
    public void sampleInput1() {
        root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        assertEquals(13, kth.kthLargestLevelSum(root, 2));
    }

    @Test
    public void sampleInput2() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        assertEquals(3, kth.kthLargestLevelSum(root, 1));
    }
}

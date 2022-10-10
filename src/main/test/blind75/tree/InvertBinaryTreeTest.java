package blind75.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InvertBinaryTreeTest {
    private final InvertBinaryTree invert = new InvertBinaryTree();
    private TreeNode root;

    @Test
    public void sampleInput1() {
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = invert.invertTree(root);

        assertEquals(4, invertedRoot.val);
        assertEquals(7, invertedRoot.left.val);
        assertEquals(2, invertedRoot.right.val);
        assertEquals(9, invertedRoot.left.left.val);
        assertEquals(6, invertedRoot.left.right.val);
        assertEquals(3, invertedRoot.right.left.val);
        assertEquals(1, invertedRoot.right.right.val);
    }

    @Test
    public void sampleInput2() {
        TreeNode invertedRoot = invert.invertTree(null);
        assertNull(invertedRoot);
    }

    @Test
    public void sampleInput3() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode invertedRoot = invert.invertTree(root);

        assertEquals(2, invertedRoot.val);
        assertEquals(3, invertedRoot.left.val);
        assertEquals(1, invertedRoot.right.val);
    }
}

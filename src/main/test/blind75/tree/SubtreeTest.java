package blind75.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubtreeTest {
    private final Subtree s = new Subtree();
    private TreeNode root;
    private TreeNode subroot;

    @Test
    public void sampleInput1() {
        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        subroot = new TreeNode(4);
        subroot.left = new TreeNode(1);
        subroot.right = new TreeNode(2);

        assertTrue(s.isSubtree(root, subroot));
    }

    @Test
    public void sampleInput2() {
        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        subroot = new TreeNode(4);
        subroot.left = new TreeNode(1);
        subroot.right = new TreeNode(2);

        assertFalse(s.isSubtree(root, subroot));
    }
}

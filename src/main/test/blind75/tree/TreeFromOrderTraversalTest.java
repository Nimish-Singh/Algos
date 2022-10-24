package blind75.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreeFromOrderTraversalTest {
    private final TreeFromOrderTraversal tree = new TreeFromOrderTraversal();
    private int[] preorder;
    private int[] inorder;

    @Test
    public void sampleInput1() {
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode constructedTree = tree.buildTree(preorder, inorder);

        assertEquals(3, constructedTree.val);
        assertEquals(9, constructedTree.left.val);
        assertNull(constructedTree.left.left);
        assertNull(constructedTree.left.right);
        assertEquals(20, constructedTree.right.val);
        assertEquals(15, constructedTree.right.left.val);
        assertNull(constructedTree.right.left.left);
        assertNull(constructedTree.right.left.right);
        assertEquals(7, constructedTree.right.right.val);
        assertNull(constructedTree.right.right.left);
        assertNull(constructedTree.right.right.right);
    }

    @Test
    public void sampleInput2() {
        preorder = new int[]{-1};
        inorder = new int[]{-1};
        TreeNode constructedTree = tree.buildTree(preorder, inorder);
        assertEquals(-1, constructedTree.val);
        assertNull(constructedTree.left);
        assertNull(constructedTree.right);
    }
}

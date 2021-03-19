package dfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreePathSumTest {
    private TreePathSum treePathSum = new TreePathSum();
    private Node root;

    @Before
    public void setUp() {
        root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
    }

    @Test
    public void sampleInput1() {
        assertTrue(treePathSum.hasPath(root, 23));
    }

    @Test
    public void sampleInput2() {
        assertFalse(treePathSum.hasPath(root, 16));
    }
}

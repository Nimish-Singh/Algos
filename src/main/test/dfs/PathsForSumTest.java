package dfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathsForSumTest {
    private PathsForSum paths = new PathsForSum();
    private Node root;

    @Before
    public void setUp() {
        root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(9);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
    }

    @Test
    public void sampleInput1() {
        assertEquals(3, paths.count(root, 12));
    }
}

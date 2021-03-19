package dfs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathWithGivenSequenceTest {
    private PathWithGivenSequence path = new PathWithGivenSequence();
    private Node root;

    @Before
    public void setUp() {
        root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(5);
    }

    @Test
    public void sampleInput1() {
        List<Integer> testPath = new ArrayList<>();
        testPath.add(1);
        testPath.add(1);
        testPath.add(6);
        assertTrue(path.exists(root, testPath));
    }

    @Test
    public void sampleInput2() {
        List<Integer> testPath = new ArrayList<>();
        testPath.add(1);
        testPath.add(0);
        testPath.add(7);
        assertFalse(path.exists(root, testPath));
    }
}

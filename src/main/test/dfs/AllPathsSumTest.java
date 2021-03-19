package dfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AllPathsSumTest {
    private AllPathsSum allPathsSum = new AllPathsSum();

    @Test
    public void sampleInput1() {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(4);
        root.right.left = new Node(10);
        root.right.right = new Node(5);

        List<List<Integer>> paths = allPathsSum.paths(root, 23);

        assertEquals(2, paths.size());
        assertTrue(paths.contains(Arrays.asList(12, 7, 4)));
        assertTrue(paths.contains(Arrays.asList(12, 1, 10)));
    }
}

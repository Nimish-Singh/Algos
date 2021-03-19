package bfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReverseLevelOrderTraversalTest {
    private ReverseLevelOrderTraversal reverseTraversal = new ReverseLevelOrderTraversal();

    @Test
    public void sampleInput1() {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);

        List<List<Integer>> traversalList = reverseTraversal.traverse(root);
        assertEquals(3, traversalList.size());
        assertArrayEquals(new int[] {9, 10, 5}, traversalList.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {7, 1}, traversalList.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {12}, traversalList.get(2).stream().mapToInt(x -> x).toArray());
    }
}

package bfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ZigZagTraversalTest {
    private ZigZagTraversal zigZagTraversal = new ZigZagTraversal();

    @Test
    public void sampleInput1() {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        root.right.left.left = new Node(20);
        root.right.left.right = new Node(17);

        List<List<Integer>> traversalList = zigZagTraversal.traverse(root);
        assertEquals(4, traversalList.size());
        assertArrayEquals(new int[] {12}, traversalList.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {1, 7}, traversalList.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {9, 10, 5}, traversalList.get(2).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {17, 20}, traversalList.get(3).stream().mapToInt(x -> x).toArray());
    }
}

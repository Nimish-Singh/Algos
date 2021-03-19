package bfs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDepthTest {
    private MinimumDepth minimumDepth = new MinimumDepth();

    @Test
    public void sampleInput1() {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        root.right.left.left = new Node(11);
        assertEquals(3, minimumDepth.find(root));
    }
}

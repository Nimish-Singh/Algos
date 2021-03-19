package bfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelOrderSuccessorTest {
    private LevelOrderSuccessor successor = new LevelOrderSuccessor();
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
        assertEquals(7, successor.find(root, 12).value);
    }

    @Test
    public void sampleInput2() {
        assertEquals(10, successor.find(root, 9).value);
    }
}
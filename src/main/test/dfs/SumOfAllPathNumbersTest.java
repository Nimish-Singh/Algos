package dfs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfAllPathNumbersTest {
    private SumOfAllPathNumbers sum = new SumOfAllPathNumbers();

    @Test
    public void sampleInput1() {
        Node root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(2);
        root.right.right = new Node(9);

        assertEquals(408, sum.find(root)); // 17 + 192 + 199
    }

    @Test
    public void sampleInput2() {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(5);

        assertEquals(332, sum.find(root)); // 101 + 116 + 115
    }
}

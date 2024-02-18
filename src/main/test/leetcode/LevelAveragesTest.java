package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LevelAveragesTest {
    private final LevelAverages averages = new LevelAverages();
    private TreeNode root;

    @Test
    public void sampleInput1() {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertArrayEquals(new Double[]{3.00000, 14.50000, 11.00000}, averages.averageOfLevels(root).toArray());
    }

    @Test
    public void sampleInput2() {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        assertArrayEquals(new Double[]{3.00000, 14.50000, 11.00000}, averages.averageOfLevels(root).toArray());
    }
}

package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobber3Test {
    private final HouseRobber3 hr = new HouseRobber3();
    private TreeNode root;

    @Test
    public void sampleInput1() {
        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        ;
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        assertEquals(7, hr.rob(root));
    }

    @Test
    public void sampleInput2() {
        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        ;
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        assertEquals(9, hr.rob(root));
    }
}

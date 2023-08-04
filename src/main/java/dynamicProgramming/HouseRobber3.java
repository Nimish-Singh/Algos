package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/house-robber-iii/
public class HouseRobber3 {
    public int rob(TreeNode root) {
//        return recursive(root);

        Map<TreeNode, Integer> memo = new HashMap<>();
        return topDown(root, memo);
    }

    private int topDown(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null)
            return 0;

        if (memo.get(root) != null)
            return memo.get(root);

        int onTakingThisNode = root.val;
        if (root.left != null) {
            onTakingThisNode += topDown(root.left.left, memo);
            onTakingThisNode += topDown(root.left.right, memo);
        }

        if (root.right != null) {
            onTakingThisNode += topDown(root.right.left, memo);
            onTakingThisNode += topDown(root.right.right, memo);
        }

        int onNotTakingThisNode = topDown(root.left, memo) + topDown(root.right, memo);

        memo.put(root, Math.max(onTakingThisNode, onNotTakingThisNode));
        return memo.get(root);
    }

    private int recursive(TreeNode root) {
        if (root == null)
            return 0;

        int onTakingThisNode = root.val;
        if (root.left != null) {
            onTakingThisNode += recursive(root.left.left);
            onTakingThisNode += recursive(root.left.right);
        }

        if (root.right != null) {
            onTakingThisNode += recursive(root.right.left);
            onTakingThisNode += recursive(root.right.right);
        }

        int onNotTakingThisNode = recursive(root.left) + recursive(root.right);

        return Math.max(onTakingThisNode, onNotTakingThisNode);
    }
}

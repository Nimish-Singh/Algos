package dynamicProgramming;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBST2 {
    // https://leetcode.com/problems/unique-binary-search-trees-ii/editorial/
    public List<TreeNode> generateTrees(int n) {
//        return recursive(1, n);

        Map<String, List<TreeNode>> memo = new HashMap<>();
        return topDown(1, n, memo);
    }

    private List<TreeNode> topDown(int start, int end, Map<String, List<TreeNode>> memo) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        if (memo.containsKey(start + ":" + end)) {
            return memo.get(start + ":" + end);
        }

        // Iterate through all values from start to end to construct left and right subtree recursively.
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = topDown(start, i - 1, memo);
            List<TreeNode> rightSubTrees = topDown(i + 1, end, memo);

            // Loop through all left and right subtrees and connect them to ith root.
            for (TreeNode left: leftSubTrees) {
                for (TreeNode right: rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        memo.put(start + ":" + end, result);
        return result;
    }

    private List<TreeNode> recursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        // Iterate through all values from start to end to construct left and right subtree recursively.
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = recursive(start, i - 1);
            List<TreeNode> rightSubTrees = recursive(i + 1, end);

            // Loop through all left and right subtrees and connect them to ith root.
            for (TreeNode left: leftSubTrees) {
                for (TreeNode right: rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


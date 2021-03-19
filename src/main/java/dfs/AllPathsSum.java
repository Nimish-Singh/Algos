package dfs;

import java.util.ArrayList;
import java.util.List;

// Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’
public class AllPathsSum {
    public List<List<Integer>> paths(Node root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), paths);
        return paths;
    }

    private void helper(Node root, int sum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (root != null && root.value == sum && root.left == null && root.right == null) {
            currentPath.add(root.value);
            paths.add(currentPath);
            return;
        }

        if (root == null || sum == 0 || root.value > sum) {
            currentPath.clear();
            return;
        }

        ArrayList<Integer> path = new ArrayList<>(currentPath);
        path.add(root.value);
        if (root.left != null) helper(root.left, sum - root.value, path, paths);
        if (root.right != null) helper(root.right, sum - root.value, path, paths);
    }
}

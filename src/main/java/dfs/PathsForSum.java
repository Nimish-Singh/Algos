package dfs;

import java.util.ArrayList;
import java.util.ListIterator;
// Important
// Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
// The paths can start or end at any node but all paths must follow direction from parent to child (top to bottom)
public class PathsForSum {
    public int count(Node root, int sum) {
        return helper(root, sum, new ArrayList<>());
    }

    private int helper(Node root, int sum, ArrayList<Integer> currentPath) {
        if (root == null)
            return 0;

        currentPath.add(root.value);
        int pathCount = 0, pathSum = 0;

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();

            if (pathSum == sum)
                pathCount++;
        }

        pathCount += helper(root.left, sum, currentPath);
        pathCount += helper(root.right, sum, currentPath);
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }
}

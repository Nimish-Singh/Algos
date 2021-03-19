package dfs;

import java.util.List;

// Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree
public class PathWithGivenSequence {
    public boolean exists(Node root, List<Integer> path) {
        if (root == null)
            return path.isEmpty();

        if (path.isEmpty())
            return false;

        if (root.value != path.get(0))
            return false;

        path.remove(0);
        return exists(root.left, path) || exists(root.right, path);
    }
}

package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest level comes first
public class ReverseLevelOrderTraversal {
    public List<List<Integer>> traverse(Node root) {
        if (root == null)
            return Collections.emptyList();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> traversal = new LinkedList<>();

        while (!queue.isEmpty()) {
            int processedNodes = 0, nodesAtThisLevel = queue.size();
            List<Integer> levelTraversal = new ArrayList<>();

            while (processedNodes < nodesAtThisLevel) {
                Node node = queue.poll();
                levelTraversal.add(node.value);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                processedNodes++;
            }

            traversal.add(0, levelTraversal);
        }
        return traversal;
    }
}

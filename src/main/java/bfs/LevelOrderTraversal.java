package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Traverse a binary tree level-wise
public class LevelOrderTraversal {
    public List<List<Integer>> traverse(Node root) {
        if (root == null)
            return Collections.emptyList();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> traversal = new ArrayList<>();

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

            traversal.add(levelTraversal);
        }
        return traversal;
    }
}

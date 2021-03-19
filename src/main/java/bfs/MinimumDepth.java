package bfs;

import java.util.LinkedList;
import java.util.Queue;

// Find the minimum depth of a binary tree (along the shortest path from the root node to the nearest leaf node)
public class MinimumDepth {
    public int find(Node root) {
        if (root == null)
            return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int minDepth = 1;
        while (!queue.isEmpty()) {
            int processedNodes = 0, nodesAtThisLevel = queue.size();

            while (processedNodes < nodesAtThisLevel) {
                Node node = queue.poll();

                if (node.left == null && node.right == null)
                    return minDepth;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                processedNodes++;
            }
            minDepth++;
        }
        return minDepth;
    }
}

package bfs;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree and a node, find the level order successor of the given node in the tree
public class LevelOrderSuccessor {
    public Node find(Node root, int key) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int processedNodes = 0, nodesAtThisLevel = queue.size();

            while (processedNodes < nodesAtThisLevel) {
                Node node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (node.value == key)
                    return queue.poll();

                processedNodes++;
            }
        }
        return null;
    }
}

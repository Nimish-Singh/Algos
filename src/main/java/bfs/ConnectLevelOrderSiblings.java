package bfs;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, connect each node with its level order successor. The last node of each level should point to a null node
public class ConnectLevelOrderSiblings {
    public void connect(NodeWithConnection root) {
        if (root == null)
            return;

        Queue<NodeWithConnection> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int processedNodes = 0, nodesAtThisLevel = queue.size();
            NodeWithConnection previous = null;

            while (processedNodes < nodesAtThisLevel) {
                NodeWithConnection node = queue.poll();
                if (previous != null)
                    previous.next = node;
                previous = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                processedNodes++;
            }
        }
    }
}

class NodeWithConnection {
    int value;
    NodeWithConnection left, right, next;

    NodeWithConnection(int value) {
        this.value = value;
    }
}

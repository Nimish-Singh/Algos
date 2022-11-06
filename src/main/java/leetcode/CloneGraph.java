package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/clone-graph/
public class CloneGraph {
    private Map<Integer, Node> clonedNodeValues;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        clonedNodeValues = new HashMap<>();

        return helper(node);
    }

    private Node helper(Node node) {
        if (clonedNodeValues.containsKey(node.val))
            return clonedNodeValues.get(node.val);

        ArrayList<Node> neighbours = new ArrayList<>();
        Node clonedNode = new Node(node.val);
        clonedNodeValues.put(node.val, clonedNode);

        for (Node neighbour : node.neighbors) {
            if (!clonedNodeValues.containsKey(neighbour.val))
                clonedNodeValues.put(neighbour.val, helper(neighbour));
            neighbours.add(clonedNodeValues.get(neighbour.val));
        }

        clonedNode.neighbors = neighbours;
        return clonedNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
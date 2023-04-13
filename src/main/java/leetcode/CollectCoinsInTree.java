package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/collect-coins-in-a-tree/description/
public class CollectCoinsInTree {
    // https://leetcode.com/problems/collect-coins-in-a-tree/solutions/3343497/easy-bfs-intuition-explained-o-n-tc-and-sc-trim-c-java/
    public int collectTheCoins(int[] coins, int[][] edges) {
        if (coins.length <= 1) {
            return 0;
        }

        int nodesSize = coins.length;
        List<Set<Integer>> adjacencyList = new ArrayList<>();
        Queue<Integer> nodesToRemove = new LinkedList<>();
        int totalEdgeTraversals = 2 * edges.length;
        int deletedEdges = 0;

        for (int index = 0; index < nodesSize; index++)
            adjacencyList.add(new HashSet<>());

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // Marking all non-coin leaf nodes for deletion
        for (int index = 0; index < nodesSize; index++) {
            if (adjacencyList.get(index).size() == 1 && coins[index] == 0) {
                nodesToRemove.offer(index);
            }
        }

        while (!nodesToRemove.isEmpty()) {
            Integer node = nodesToRemove.poll();
            if (adjacencyList.get(node).size() == 0)
                continue;

            int adjacentNode = adjacencyList.get(node).iterator().next();
            adjacencyList.get(node).remove(adjacentNode);
            adjacencyList.get(adjacentNode).remove(node);

            // Mark such adjacent nodes which are non-coins
            if (adjacencyList.get(adjacentNode).size() == 1 && coins[adjacentNode] == 0) {
                nodesToRemove.offer(adjacentNode);
            }
            deletedEdges += 2;
        }

        // By this time, we have removed all non-coin leaf nodes. Now we mark coin leaf nodes
        for (int index = 0; index < nodesSize; index++) {
            if (adjacencyList.get(index).size() == 1) {
                nodesToRemove.offer(index);
            }
        }

        // Remove coin leaf node and parent, because coin is accessible from grandparent node
        for (int times = 1; times <= 2; times++) {
            int queueSize = nodesToRemove.size();
            while (queueSize-- > 0) {
                Integer node = nodesToRemove.poll();
                if (adjacencyList.get(node).size() == 0)
                    continue;

                int adjacentNode = adjacencyList.get(node).iterator().next();
                adjacencyList.get(node).remove(adjacentNode);
                adjacencyList.get(adjacentNode).remove(node);

                // Marking the second level for removal
                if (adjacencyList.get(adjacentNode).size() == 1) {
                    nodesToRemove.offer(adjacentNode);
                }
                deletedEdges += 2;
            }
        }

        return totalEdgeTraversals - deletedEdges;
    }
}

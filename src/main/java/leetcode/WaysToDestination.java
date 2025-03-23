package leetcode;

import java.util.*;

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
public class WaysToDestination {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        // Build adjacency list
        List<List<NodeInfo>> adjacencyList = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            adjacencyList.get(startNode).add(new NodeInfo(endNode, travelTime));
            adjacencyList.get(endNode).add(new NodeInfo(startNode, travelTime));
        }

        // Min-Heap (priority queue) for Dijkstra
        PriorityQueue<NodeInfo> minHeap = new PriorityQueue<>(Comparator.comparingLong(nodeInfo -> nodeInfo.travelTime));

        // Store shortest time to each node
        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        // Number of ways to reach each node in shortest time
        int[] pathCount = new int[n];

        shortestTime[0] = 0; // Distance to source is 0
        pathCount[0] = 1; // 1 way to reach node 0

        minHeap.offer(new NodeInfo(0, 0));

        while (!minHeap.isEmpty()) {
            NodeInfo smallestTravelTimeNode = minHeap.poll();
            long currTime = smallestTravelTimeNode.travelTime; // Current shortest time
            int currNode = smallestTravelTimeNode.nodeName;

            // Skip outdated distances
            if (currTime > shortestTime[currNode]) {
                continue;
            }

            for (NodeInfo neighbor : adjacencyList.get(currNode)) {
                int neighborNode = neighbor.nodeName;
                long roadTime = neighbor.travelTime;

                // Found a new shortest path → Update shortest time and reset path count
                if (currTime + roadTime < shortestTime[neighborNode]) {
                    shortestTime[neighborNode] = currTime + roadTime;
                    pathCount[neighborNode] = pathCount[currNode];
                    minHeap.offer(new NodeInfo(neighborNode, shortestTime[neighborNode]));
                }
                // Found another way with the same shortest time → Add to path count
                else if (currTime + roadTime == shortestTime[neighborNode]) {
                    pathCount[neighborNode] = (pathCount[neighborNode] + pathCount[currNode]) % MOD;
                }
            }
        }

        return pathCount[n - 1];
    }

    private class NodeInfo {
        int nodeName;
        long travelTime;

        public NodeInfo(int nodeName, long travelTime) {
            this.nodeName = nodeName;
            this.travelTime = travelTime;
        }
    }
}

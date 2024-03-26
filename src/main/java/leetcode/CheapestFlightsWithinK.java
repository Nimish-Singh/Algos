package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlightsWithinK {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();

        for (int vertex = 0; vertex < n; vertex++)
            adjacencyMap.put(vertex, new ArrayList<>());

        for (int[] flight : flights) {
            adjacencyMap.get(flight[0]).add(new int[] {flight[1], flight[2]}); // destination, cost pair
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int currentSize = queue.size();

            while (currentSize-- > 0) {
                int[] current = queue.poll();

                for (int[] neighbour : adjacencyMap.get(current[0])) {
                    int hopNode = neighbour[0], price = neighbour[1];
                    if (price + current[1] >= minCost[hopNode])
                        continue;

                    minCost[hopNode] = price + current[1];
                    queue.offer(new int[] {hopNode, minCost[hopNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}

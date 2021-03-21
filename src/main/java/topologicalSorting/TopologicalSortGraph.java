package topologicalSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Find topological sort order of a graph
public class TopologicalSortGraph {
    public List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            adjacencyListMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            adjacencyListMap.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                sources.offer(entry.getKey());

        while (!sources.isEmpty()) {
            Integer source = sources.poll();
            sortedOrder.add(source);
            List<Integer> children = adjacencyListMap.get(source);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.offer(child);
            }
        }

        if (sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;
    }
}

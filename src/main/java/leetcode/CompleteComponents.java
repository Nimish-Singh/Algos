package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-complete-components/
public class CompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> degree = new HashMap<>();

        for (int[] edge : edges) {
            degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, List<Integer>> entries = uf.getComponents();
        int answer = 0;

        for (Map.Entry<Integer, List<Integer>> entry : entries.entrySet()) {
            if (entry.getValue().size() == 1) {
                answer++;
                continue;
            }

            int degreeSum = 0;
            for (Integer node : entry.getValue()) {
                degreeSum += degree.get(node);
            }

            int nodes = entry.getValue().size();
            if (degreeSum == nodes * (nodes - 1))
                answer++;
        }

        return answer;
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new HashMap<>();
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent.put(i, i);
            }
        }

        public int find(int x) {
            if (parent.get(x) == x)
                return x;

            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] > rank[py]) {
                parent.put(py, px);
                rank[px]++;
            } else {
                parent.put(px, py);
                rank[py]++;
            }
        }

        public Map<Integer, List<Integer>> getComponents() {
            Map<Integer, List<Integer>> components = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
                components.putIfAbsent(find(entry.getValue()), new ArrayList<>());

                components.get(find(entry.getValue())).add(entry.getKey());
            }

            return components;
        }
    }
}

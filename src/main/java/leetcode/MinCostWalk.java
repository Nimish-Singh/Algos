package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/
public class MinCostWalk {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        int[] componentCost = new int[n];
        Arrays.fill(componentCost, Integer.MAX_VALUE);
        for (int[] edge : edges) {
            int parent = uf.find(edge[0]);
            componentCost[parent] &= edge[2];
        }

        int[] answer = new int[query.length];

        for (int index = 0; index < query.length; index++) {
            if (uf.find(query[index][0]) != uf.find(query[index][1])) {
                answer[index] = -1;
            } else {
                int parent = uf.find(query[index][0]);
                answer[index] = componentCost[parent];
            }
        }

        return answer;
    }

    private class UnionFind {
        private int[] parents;
        private int[] rank;

        public UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];

            for (int index = 0; index < n; index++)
                parents[index] = index;
        }

        public int find(int x) {
            if (parents[x] == x)
                return x;

            parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] > rank[py]) {
                parents[py] = px;
                rank[px]++;
            } else {
                parents[px] = py;
                rank[py]++;
            }
        }
    }
}

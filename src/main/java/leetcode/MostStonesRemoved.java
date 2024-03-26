package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
public class MostStonesRemoved {
    // Also see
    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/solutions/197693/java-union-find/
    public int removeStones(int[][] stones) {
        int stonesNum = stones.length;

        UnionFind uf = new UnionFind(stonesNum);
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();

        for (int i = 0; i < stonesNum; i++) {
            int r = stones[i][0];
            int c = stones[i][1];

            rows.putIfAbsent(r, i);
            cols.putIfAbsent(c, i);

            uf.union(rows.get(r), i);
            uf.union(cols.get(c), i);
        }

        return stonesNum - uf.getIslands();
    }

    private class UnionFind {
        private int[] parents;
        private int islands;

        UnionFind(int n) {
            islands = n;
            parents = new int[n];
            for (int i = 0; i < n; i++)
                parents[i] = i;
        }

        private int find(int x) {
            if (parents[x] == x)
                return x;
            parents[x] = find(parents[x]);
            return parents[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px != py) {
                parents[px] = py;
                islands--;
            }
        }

        int getIslands() {
            return islands;
        }
    }
}

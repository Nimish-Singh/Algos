package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Important
// https://leetcode.com/problems/accounts-merge/description/
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        Map<String, Integer> emailGroup = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int currentSize = accounts.get(i).size();

            for (int j = 1; j < currentSize; j++) {
                String name = accounts.get(i).get(0);
                String email = accounts.get(i).get(j);

                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    uf.union(i, emailGroup.get(email));
                }
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();

        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int parent = uf.find(group);

            if (!components.containsKey(parent)) {
                components.put(parent, new ArrayList<String>());
            }

            components.get(parent).add(email);
        }

        List<List<String>> answer = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accounts.get(group).get(0));
            answer.add(component);
        }

        return answer;
    }

    private class UnionFind {
        private int[] parents;
        private int[] rank;

        UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (x == parents[x])
                return x;

            parents[x] = find(parents[x]);
            return parents[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] == rank[py]) {
                parents[px] = py;
                rank[py]++;
                return;
            }

            if (rank[px] < rank[py]) {
                parents[py] = px;
                rank[px]++;
            } else {
                parents[px] = py;
                rank[py]++;
            }
        }
    }
}

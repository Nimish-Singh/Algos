package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

//        return simpleSequenceCheck(nums);

//        return mapCheck(nums);

        return disjointSetApproach(nums);
    }

    private int disjointSetApproach(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        Map<Integer, Integer> elementIndexMap = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (elementIndexMap.containsKey(nums[index])) {
                continue;
            }

            elementIndexMap.put(nums[index], index);
            if (elementIndexMap.containsKey(nums[index] - 1)) {
                // union with previous element
                uf.union(index, elementIndexMap.get(nums[index] - 1));
            }
            if (elementIndexMap.containsKey(nums[index] + 1)) {
                // union with next element
                uf.union(index, elementIndexMap.get(nums[index] + 1));
            }
        }
        return uf.maxUnionSize();
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int[] nums) {
            parent = new int[nums.length];
            for (int index = 0; index < parent.length; index++) {
                parent[index] = index;
            }
        }

        private int find(int element) {
            if (parent[element] == element) {
                return element;
            }
            parent[element] = find(parent[element]);
            return parent[element];
        }

        public void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);

            parent[parentI] = parentJ;
        }

        public int maxUnionSize() {
            int[] count = new int[parent.length];
            int max = 0;

            for (int index = 0; index < count.length; index++) {
                count[find(index)]++;
                max = Math.max(max, count[parent[index]]);
            }
            return max;
        }
    }

    // https://leetcode.com/problems/longest-consecutive-sequence/solutions/41055/my-really-simple-java-o-n-solution-accepted/
    private int mapCheck(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        for (int element : nums) {
            if (!map.containsKey(element)) { // non-duplicate
                int left = map.getOrDefault(element - 1, 0);
                int right = map.getOrDefault(element + 1, 0);

                int sequenceLength = left + right + 1;
                map.put(element, sequenceLength);

                maxLength = Math.max(maxLength, sequenceLength);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if element has no neighbors
                map.put(element - left, sequenceLength);
                map.put(element + right, sequenceLength);
            }
        }
        return maxLength;
    }

    private int simpleSequenceCheck(int[] nums) {
        Set<Integer> elements = new HashSet<>();

        for (int element : nums)
            elements.add(element);

        int maxLength = 0;
        for (int element : nums) {
            if (!elements.contains(element - 1)) {
                int nextElementToCheck = element + 1;
                while (elements.contains(nextElementToCheck))
                    nextElementToCheck++;
                maxLength = Math.max(maxLength, nextElementToCheck - element);
            }
        }
        return maxLength;
    }
}

package permutations;

import java.util.ArrayList;
import java.util.List;
// Important
// Find all subsets of a set
public class Subsets {
    public List<List<Integer>> computeRecursive(List<Integer> set) {
        if (set.isEmpty()) {
            ArrayList<List<Integer>> emptySubset = new ArrayList<>();
            emptySubset.add(new ArrayList<>());
            return emptySubset;
        }

        Integer firstElement = set.get(0);
        List<Integer> restOfSet = set.subList(1, set.size());

        List<List<Integer>> subsets = computeRecursive(restOfSet);

        List<List<Integer>> allSubsets = new ArrayList<>();
        subsets.forEach(list -> {
            allSubsets.add(new ArrayList<>(list));
            list.add(0, firstElement);
            allSubsets.add(list);
        });
        return allSubsets;
    }

    public List<List<Integer>> compute(List<Integer> set) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int elementOfSet: set) {
            int currentSubsetSize = subsets.size();

            for (int i = 0; i < currentSubsetSize; i++) {
                List<Integer> existingSubset = new ArrayList<>(subsets.get(i));
                existingSubset.add(elementOfSet);
                subsets.add(existingSubset);
            }
        }
        return subsets;
    }
}

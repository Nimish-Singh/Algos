package permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Find all subsets of a set, where the elements of the given set chas duplicates
public class SubsetsWithDuplicateElements {
    public List<List<Integer>> compute(List<Integer> set) {
        Collections.sort(set);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < set.size(); i++) {
            startIndex = 0;

            if (i > 1 && set.get(i).equals(set.get(i - 1)))
                startIndex = endIndex + 1;
            endIndex = subsets.size() - 1;

            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> existingSubset = new ArrayList<>(subsets.get(j));
                existingSubset.add(set.get(i));
                subsets.add(existingSubset);
            }
        }
        return subsets;
    }
}

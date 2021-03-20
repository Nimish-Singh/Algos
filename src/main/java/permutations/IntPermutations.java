package permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a list of distinct numbers, find all of its permutations
public class IntPermutations {
    public List<List<Integer>> compute (List<Integer> set) {
        List<List<Integer>> permutations = new ArrayList<>();

        Queue<List<Integer>> intermediatePermutations = new LinkedList<>();
        intermediatePermutations.add(new ArrayList<>());

        for (int number: set) {
            int existingPermutationsSize = intermediatePermutations.size();

            for (int i = 0; i < existingPermutationsSize; i++) {
                List<Integer> existingPermutation = intermediatePermutations.poll();

                for (int index = 0; index <= existingPermutation.size(); index++) {
                    List<Integer> newPermutation = new ArrayList<>(existingPermutation);
                    newPermutation.add(index, number);

                    if (newPermutation.size() == set.size())
                        permutations.add(newPermutation);
                    else
                        intermediatePermutations.add(newPermutation);
                }
            }
        }

        return permutations;
    }
}

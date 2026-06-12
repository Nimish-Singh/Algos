package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class RandomizedSet {
    private final Map<Integer, Integer> indexMap;
    private final List<Integer> accessList;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        accessList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!indexMap.containsKey(val)) {
            accessList.add(val);
            indexMap.put(val, accessList.size() - 1);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (indexMap.containsKey(val)) {
            Integer indexToRemove = indexMap.get(val);
            Integer elementToKeep = accessList.get(accessList.size() - 1);
            accessList.set(indexToRemove, elementToKeep);
            indexMap.put(elementToKeep, indexToRemove);

            accessList.removeLast();
            indexMap.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        int random = (int) (Math.random() * accessList.size());
        return accessList.get(random);
    }
}

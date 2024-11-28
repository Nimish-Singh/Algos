package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/lfu-cache/
public class LFUCache {
    // key: original key, value: frequency and original value.
    private final Map<Integer, int[]> cache;
    // key: frequency, value: All keys that have the same frequency.
    private final Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minFrequency;
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minFrequency = 0;
    }

    public int get(int key) {
        int[] frequencyAndValue = cache.get(key);
        if (frequencyAndValue == null)
            return -1;

        int frequency = frequencyAndValue[0];
        Set<Integer> keysWithFrequency = frequencies.get(frequency);
        keysWithFrequency.remove(key);

        if (keysWithFrequency.isEmpty()) {
            frequencies.remove(frequency);
            if (minFrequency == frequency)
                ++minFrequency;
        }

        int value = frequencyAndValue[1];
        insert(key, frequency + 1, value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        int[] frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null) {
            cache.put(key, new int[]{frequencyAndValue[0], value});

            // to add to the access frequency
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            LinkedHashSet<Integer> keysWithMinimumFrequency = frequencies.get(minFrequency);

            Integer keyToDelete = keysWithMinimumFrequency.getFirst();
            cache.remove(keyToDelete);
            keysWithMinimumFrequency.remove(keyToDelete);

            if (keysWithMinimumFrequency.isEmpty())
                frequencies.remove(minFrequency);
        }

        minFrequency = 1;
        insert(key, 1, value);
    }

    private void insert(int key, int frequency, int value) {
        cache.put(key, new int[]{frequency, value});
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }
}

package leetcode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LFUCacheTest {
    private LFUCache cache;

    @Test
    public void sampleInput1() {
        cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));

        cache.put(3, 3);

        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));

        cache.put(4, 4);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}

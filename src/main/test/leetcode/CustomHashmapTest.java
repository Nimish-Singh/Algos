package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomHashmapTest {
    private CustomHashmap hashmap;

    @Test
    public void sampleInput1() {
        hashmap = new CustomHashmap(5);

        // Get key from empty map
        assertTrue(hashmap.get(7).isEmpty());

        // Remove key from empty map
        hashmap.remove(3);

        hashmap.put(1, 10);
        hashmap.put(2, 20);
        hashmap.put(3, 30);
        assertEquals(20, hashmap.get(2).get().intValue());

        // Overwrite key and access it
        hashmap.put(2, 200);
        assertEquals(200, hashmap.get(2).get().intValue());

        hashmap.put(4, 40);
        hashmap.put(5, 50);

        // Capacity exceeded
        assertThrows(RuntimeException.class, () -> hashmap.put(6, 60));

        // Remove and then put a new key
        hashmap.remove(4);
        hashmap.put(6, 60);
        assertTrue(hashmap.get(4).isEmpty());
        assertEquals(60, hashmap.get(6).get().intValue());

        // Overwrite key and access it
        hashmap.put(6, 600);
        assertEquals(600, hashmap.get(6).get().intValue());

        // Capacity exceeded
        assertThrows(RuntimeException.class, () -> hashmap.put(7, 70));
    }
}

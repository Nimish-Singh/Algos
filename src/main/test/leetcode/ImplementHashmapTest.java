package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplementHashmapTest {
    private final ImplementHashmap myHashMap = new ImplementHashmap();

    @Test
    public void sampleInput1() {
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        assertEquals(1, myHashMap.get(1));
        assertEquals(-1, myHashMap.get(3));
        myHashMap.put(2, 1);
        assertEquals(1, myHashMap.get(2));
        myHashMap.remove(2);
        assertEquals(-1, myHashMap.get(2));
    }
}

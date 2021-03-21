package topologicalSorting;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopologicalSortGraphTest {
    private TopologicalSortGraph topologicalSort = new TopologicalSortGraph();

    @Test
    public void sampleInput1() {
        List<Integer> sort = topologicalSort.sort(4, new int[][]{
                new int[]{3, 2},
                new int[]{3, 0},
                new int[]{2, 0},
                new int[]{2, 1},
        });
        assertEquals(3, sort.get(0).intValue());
        assertEquals(2, sort.get(1).intValue());
        assertEquals(0, sort.get(2).intValue());
        assertEquals(1, sort.get(3).intValue());
    }
}

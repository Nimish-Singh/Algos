package greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupPeopleTest {
    private final GroupPeople group = new GroupPeople();
    private int[] groupSizes;

    @Test
    public void sampleInput1() {
        groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> groups = group.groupThePeople(groupSizes);

        assertEquals(3, groups.size());
        assertTrue(groups.contains(List.of(5)));
        assertTrue(groups.contains(List.of(2, 0, 1)));
        assertTrue(groups.contains(List.of(6, 3, 4)));
    }

    @Test
    public void sampleInput2() {
        groupSizes = new int[]{2, 1, 3, 3, 3, 2};
        List<List<Integer>> groups = group.groupThePeople(groupSizes);

        assertEquals(3, groups.size());
        assertTrue(groups.contains(List.of(1)));
        assertTrue(groups.contains(List.of(4, 2, 3)));
        assertTrue(groups.contains(List.of(5, 0)));
    }
}

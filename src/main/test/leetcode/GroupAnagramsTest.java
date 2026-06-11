package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GroupAnagramsTest {
    private final GroupAnagrams group = new GroupAnagrams();
    private String[] strs;

    @Test
    public void sampleInput1() {
        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> answer = group.groupAnagrams(strs);

        assertEquals(3, answer.size());
        System.out.println(answer);

        assertArrayEquals(new String[]{"eat", "tea", "ate"}, answer.get(0).stream().map(String::new).toArray());
        assertArrayEquals(new String[]{"bat"}, answer.get(1).stream().map(String::new).toArray());
        assertArrayEquals(new String[]{"tan", "nat"}, answer.get(2).stream().map(String::new).toArray());
    }

    @Test
    public void sampleInput2() {
        strs = new String[]{""};
        List<List<String>> answer = group.groupAnagrams(strs);

        assertEquals(1, answer.size());
        assertArrayEquals(new String[]{""}, answer.get(0).stream().map(String::new).toArray());
    }

    @Test
    public void sampleInput3() {
        strs = new String[]{"a"};
        List<List<String>> answer = group.groupAnagrams(strs);

        assertEquals(1, answer.size());
        assertArrayEquals(new String[]{"a"}, answer.get(0).stream().map(String::new).toArray());
    }
}

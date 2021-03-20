package permutations;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StringPermutationsByChangingCaseTest {
    private StringPermutationsByChangingCase permutations = new StringPermutationsByChangingCase();

    @Test
    public void sampleInput1() {
        List<String> perms = permutations.compute("ad52");
        assertEquals(4, perms.size());
        assertTrue(perms.contains("ad52"));
        assertTrue(perms.contains("Ad52"));
        assertTrue(perms.contains("aD52"));
        assertTrue(perms.contains("AD52"));
    }

    @Test
    public void sampleInput2() {
        List<String> perms = permutations.compute("ab5d");
        assertEquals(8, perms.size());
        assertTrue(perms.contains("ab5d"));
        assertTrue(perms.contains("Ab5d"));
        assertTrue(perms.contains("aB5d"));
        assertTrue(perms.contains("ab5D"));
        assertTrue(perms.contains("AB5d"));
        assertTrue(perms.contains("aB5D"));
        assertTrue(perms.contains("Ab5D"));
        assertTrue(perms.contains("AB5D"));
    }
}

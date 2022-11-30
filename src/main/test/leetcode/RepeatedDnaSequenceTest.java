package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class RepeatedDnaSequenceTest {
    private final RepeatedDnaSequence dna = new RepeatedDnaSequence();

    @Test
    public void sampleInput1() {
        List<String> sequences = dna.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertArrayEquals(new String[]{"AAAAACCCCC", "CCCCCAAAAA"}, sequences.toArray(new String[0]));
    }

    @Test
    public void sampleInput2() {
        List<String> sequences = dna.findRepeatedDnaSequences("AAAAAAAAAAAAA");
        assertArrayEquals(new String[]{"AAAAAAAAAA"}, sequences.toArray(new String[0]));
    }
}

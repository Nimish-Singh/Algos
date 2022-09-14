package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShortestOperationSequenceTest {
    private final ShortestOperationSequence sequence = new ShortestOperationSequence();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new String[]{"A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"}, sequence.diffBetweenTwoStrings("ABCDEFG", "ABDFFGH"));
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new String[]{"A", "+B", "+C", "+D"}, sequence.diffBetweenTwoStrings("A", "ABCD"));
    }

    @Test
    public void sampleInput3() {
        assertArrayEquals(new String[]{"A", "+B", "C", "D", "E"}, sequence.diffBetweenTwoStrings("ACDE", "ABCDE"));
    }

    @Test
    public void sampleInput4() {
        assertArrayEquals(new String[]{"C", "+A", "B", "+A", "+A", "B", "+B", "C"}, sequence.diffBetweenTwoStrings("CBBC", "CABAABBC"));
    }

    @Test
    public void sampleInput5() {
        assertArrayEquals(new String[]{"C", "C", "B", "C"}, sequence.diffBetweenTwoStrings("CCBC", "CCBC"));
    }

    @Test
    public void sampleInput6() {
        assertArrayEquals(new String[]{"C", "-A", "B", "-A", "-A", "-A", "B", "-B", "C"}, sequence.diffBetweenTwoStrings("CABAAABBC", "CBBC"));
    }

    @Test
    public void sampleInput7() {
        assertArrayEquals(new String[]{"-A", "-A", "B", "A", "+B", "C", "+A", "C"}, sequence.diffBetweenTwoStrings("AABACC", "BABCAC"));
    }

    @Test
    public void sampleInput8() {
        assertArrayEquals(new String[]{"H", "-M", "-X", "+L", "+Z", "P", "-H", "-H", "+L", "U", "-M", "+P", "+H"}, sequence.diffBetweenTwoStrings("HMXPHHUM", "HLZPLUPH"));
    }

    @Test
    public void sampleInput9() {
        assertArrayEquals(new String[]{"+P", "+P", "G", "-H", "-M", "-X", "G", "+X", "H", "+H", "U", "-G", "-X", "L", "+L"}, sequence.diffBetweenTwoStrings("GHMXGHUGXL", "PPGGXHHULL"));
    }

    @Test
    public void sampleInput10() {
        assertArrayEquals(new String[]{"+H", "+P", "G", "-M", "+P", "+P", "M", "G", "-Z", "-G", "-G", "L", "+L", "U", "-G", "U", "-H", "+U"}, sequence.diffBetweenTwoStrings("GMMGZGGLUGUH", "HPGPPMGLLUUU"));
    }
}

package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeStringTest {
    private final DecodeString decode = new DecodeString();

    @Test
    public void sampleInput1() {
        assertEquals("aaabcbc", decode.decodeString("3[a]2[bc]"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("accaccacc", decode.decodeString("3[a2[c]]"));
    }

    @Test
    public void sampleInput3() {
        assertEquals("abcabccdcdcdef", decode.decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void sampleInput4() {
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", decode.decodeString("100[leetcode]"));
    }
}

package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountAndSayTest {
    private CountAndSay counter = new CountAndSay();

    @Test
    public void sampleInput1() {
        assertEquals("1", counter.countAndSay(1));
    }

    @Test
    public void sampleInput2() {
        assertEquals("1211", counter.countAndSay(4));
    }

    @Test
    public void sampleInput3() {
        assertEquals("13112221", counter.countAndSay(7));
    }

    @Test
    public void sampleInput4() {
        assertEquals("311311222113111231131112132112311321322112111312211312111322212311322113212221", counter.countAndSay(15));
    }
}

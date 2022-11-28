package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestoreIPAddressesTest {
    private final RestoreIPAddresses r = new RestoreIPAddresses();

    @Test
    public void sampleInput1() {
        List<String> answer = r.restoreIpAddresses("25525511135");
        assertEquals(2, answer.size());
        assertEquals("255.255.11.135", answer.get(0));
        assertEquals("255.255.111.35", answer.get(1));
    }

    @Test
    public void sampleInput2() {
        List<String> answer = r.restoreIpAddresses("0000");
        assertEquals(1, answer.size());
        assertEquals("0.0.0.0", answer.get(0));
    }

    @Test
    public void sampleInput3() {
        List<String> answer = r.restoreIpAddresses("101023");
        assertEquals(5, answer.size());
        assertEquals("1.0.10.23", answer.get(0));
        assertEquals("1.0.102.3", answer.get(1));
        assertEquals("10.1.0.23", answer.get(2));
        assertEquals("10.10.2.3", answer.get(3));
        assertEquals("101.0.2.3", answer.get(4));
    }
}

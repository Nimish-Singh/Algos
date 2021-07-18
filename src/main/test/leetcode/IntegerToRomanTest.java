package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanTest {
    private IntegerToRoman convertor = new IntegerToRoman();

    @Test
    public void sampleInput1() {
        assertEquals(convertor.intToRoman(3), "III");
    }

    @Test
    public void sampleInput2() {
        assertEquals(convertor.intToRoman(4), "IV");
    }

    @Test
    public void sampleInput3() {
        assertEquals(convertor.intToRoman(9), "IX");
    }

    @Test
    public void sampleInput4() {
        assertEquals(convertor.intToRoman(58), "LVIII");
    }

    @Test
    public void sampleInput5() {
        assertEquals(convertor.intToRoman(1994), "MCMXCIV");
    }
}

package xor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base10ComplimentTest {
    private Base10Compliment compliment = new Base10Compliment();

    @Test
    public void sampleInput1() {
        assertEquals(7, compliment.find(8));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, compliment.find(10));
    }
}

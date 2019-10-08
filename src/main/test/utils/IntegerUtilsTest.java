package utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.IntegerUtils.swap;

public class IntegerUtilsTest {

    @Test
    public void shouldReturnFirstParameter() {
        assertEquals(4, swap(4, -8));
    }
}
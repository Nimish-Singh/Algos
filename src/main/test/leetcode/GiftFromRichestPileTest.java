package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GiftFromRichestPileTest {
    private final GiftFromRichestPile gift = new GiftFromRichestPile();
    private int[] gifts;

    @Test
    public void sampleInput1() {
        gifts = new int[]{25, 64, 9, 4, 100};
        assertEquals(29, gift.pickGifts(gifts, 4));
    }

    @Test
    public void sampleInput2() {
        gifts = new int[]{1, 1, 1, 1};
        assertEquals(4, gift.pickGifts(gifts, 4));
    }
}

package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSuggestionsSystemTest {
    private final SearchSuggestionsSystem suggestionsSystem = new SearchSuggestionsSystem();
    private String[] products;

    @Test
    public void sampleInput1() {
        products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};

        List<List<String>> suggestions = suggestionsSystem.suggestedProducts(products, "mouse");

        assertEquals(5, suggestions.size());
        assertArrayEquals(new String[]{"mobile","moneypot","monitor"}, suggestions.get(0).toArray());
        assertArrayEquals(new String[]{"mobile","moneypot","monitor"}, suggestions.get(1).toArray());
        assertArrayEquals(new String[]{"mouse","mousepad"}, suggestions.get(2).toArray());
        assertArrayEquals(new String[]{"mouse","mousepad"}, suggestions.get(3).toArray());
        assertArrayEquals(new String[]{"mouse","mousepad"}, suggestions.get(4).toArray());
    }

    @Test
    public void sampleInput2() {
        products = new String[] {"havana"};

        List<List<String>> suggestions = suggestionsSystem.suggestedProducts(products, "havana");

        assertEquals(6, suggestions.size());
        assertArrayEquals(new String[]{"havana"}, suggestions.get(0).toArray());
        assertArrayEquals(new String[]{"havana"}, suggestions.get(1).toArray());
        assertArrayEquals(new String[]{"havana"}, suggestions.get(2).toArray());
        assertArrayEquals(new String[]{"havana"}, suggestions.get(3).toArray());
        assertArrayEquals(new String[]{"havana"}, suggestions.get(4).toArray());
        assertArrayEquals(new String[]{"havana"}, suggestions.get(5).toArray());
    }
}

package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecipesFromSuppliesTest {
    private final RecipesFromSupplies r = new RecipesFromSupplies();
    private String[] recipes;
    List<List<String>> ingredients;
    private String[] supplies;

    @Test
    public void sampleInput1() {
        recipes = new String[]{"bread"};
        ingredients = List.of(List.of("yeast","flour"));
        supplies = new String[]{"yeast","flour","corn"};

        List<String> creatableRecipes = r.findAllRecipes(recipes, ingredients, supplies);

        assertEquals(1, creatableRecipes.size());
        assertEquals("bread", creatableRecipes.get(0));
    }

    @Test
    public void sampleInput2() {
        recipes = new String[]{"bread","sandwich"};
        ingredients = List.of(List.of("yeast","flour"), List.of("bread","meat"));
        supplies = new String[]{"yeast","flour","meat"};

        List<String> creatableRecipes = r.findAllRecipes(recipes, ingredients, supplies);

        assertEquals(2, creatableRecipes.size());
        assertTrue(creatableRecipes.contains("bread"));
        assertTrue(creatableRecipes.contains("sandwich"));
    }

    @Test
    public void sampleInput3() {
        recipes = new String[]{"bread","sandwich","burger"};
        ingredients = List.of(List.of("yeast","flour"), List.of("bread","meat"), List.of("sandwich","meat","bread"));
        supplies = new String[]{"yeast","flour","meat"};

        List<String> creatableRecipes = r.findAllRecipes(recipes, ingredients, supplies);

        assertEquals(3, creatableRecipes.size());
        assertTrue(creatableRecipes.contains("bread"));
        assertTrue(creatableRecipes.contains("sandwich"));
        assertTrue(creatableRecipes.contains("burger"));
    }

    @Test
    public void sampleInput4() {
        recipes = new String[]{"pie"};
        ingredients = List.of(List.of("apple","flour", "eggs"));
        supplies = new String[]{"apple","flour","meat"};

        List<String> creatableRecipes = r.findAllRecipes(recipes, ingredients, supplies);

        assertTrue(creatableRecipes.isEmpty());
    }
}

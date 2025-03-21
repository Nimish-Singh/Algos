package leetcode;

import java.util.*;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
public class RecipesFromSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));

        Map<String, List<String>> adjacencyListMap = new HashMap<>();
        Map<String, Integer> indegreeMap = new HashMap<>();

        for (int index = 0; index < ingredients.size(); index++) {
            indegreeMap.put(recipes[index], 0);

            for (String ingredient : ingredients.get(index)) {
                if (!suppliesSet.contains(ingredient)) {
                    adjacencyListMap.putIfAbsent(ingredient, new ArrayList<>());

                    indegreeMap.put(recipes[index], indegreeMap.get(recipes[index]) + 1);
                    adjacencyListMap.get(ingredient).add(recipes[index]);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : indegreeMap.entrySet()) {
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());
        }

        List<String> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            String createdRecipe = queue.poll();
            answer.add(createdRecipe);

            if (!adjacencyListMap.containsKey(createdRecipe))
                continue;

            for (String recipe : adjacencyListMap.get(createdRecipe)) {
                indegreeMap.put(recipe, indegreeMap.get(recipe) - 1);

                if (indegreeMap.get(recipe) == 0)
                    queue.offer(recipe);
            }
        }

        return answer;
    }
}

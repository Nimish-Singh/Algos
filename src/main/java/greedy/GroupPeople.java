package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class GroupPeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        return firstApproach(groupSizes);
//        return conciseApproachButEqualRuntime(groupSizes);
    }

    private List<List<Integer>> conciseApproachButEqualRuntime(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> groupSizePersonsMap = new HashMap<>();

        for (int person = 0; person < groupSizes.length; person++) {
            int group = groupSizes[person];
            List<Integer> persons = groupSizePersonsMap.computeIfAbsent(group, key -> new ArrayList<>());
            persons.add(person);

            if (persons.size() == group) {
                answer.add(persons);
                groupSizePersonsMap.remove(group);
            }
        }
        return answer;
    }

    private List<List<Integer>> firstApproach(int[] groupSizes) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> groupSizePersonsMap = new HashMap<>();

        for (int person = 0; person < groupSizes.length; person++) {
            int groupSize = groupSizes[person];
            if (groupSize == 1) {
                answer.add(List.of(person));
                continue;
            }

            if (groupSizePersonsMap.containsKey(groupSize) && groupSizePersonsMap.get(groupSize).size() == groupSize - 1) {
                List<Integer> group = new ArrayList<>();
                group.add(person);
                while (!groupSizePersonsMap.get(groupSize).isEmpty()) {
                    group.add(groupSizePersonsMap.get(groupSize).remove(0));
                }
                answer.add(group);
                groupSizePersonsMap.remove(groupSize);
                continue;
            }

            if (!groupSizePersonsMap.containsKey(groupSize)) {
                groupSizePersonsMap.put(groupSize, new ArrayList<>());
            }

            List<Integer> persons = groupSizePersonsMap.get(groupSize);
            persons.add(person);
            groupSizePersonsMap.put(groupSize, persons);
        }
        return answer;
    }
}

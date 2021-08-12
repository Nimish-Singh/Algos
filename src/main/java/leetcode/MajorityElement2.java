package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

// https://leetcode.com/problems/majority-element-ii/
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(groupingBy(Function.identity(), HashMap::new, counting()));

        int requiredFrequency = nums.length / 3;

        return frequencyMap
                .keySet().stream()
                .filter(key -> frequencyMap.get(key) > requiredFrequency)
                .collect(Collectors.toList());
    }
}

package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class MinimumBoats {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0, low = 0, high = people.length - 1;
        Arrays.sort(people);
        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
            }
            high--;
            boats++;
        }
        return boats;
    }
}

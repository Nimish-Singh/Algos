package greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/cinema-seat-allocation/
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> seats = new HashMap<>();

        for (int[] rowSeat : reservedSeats) {
            if (seats.containsKey(rowSeat[0])) {
                seats.get(rowSeat[0]).add(rowSeat[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(rowSeat[1]);
                seats.put(rowSeat[0], set);
            }
        }

        int count = (n - seats.size()) * 2;

        for (Set<Integer> values : seats.values()) {
            boolean foundAisleCombo = false;

            if (!values.contains(2) && !values.contains(3) && !values.contains(4) && !values.contains(5)) {
                count++;
                foundAisleCombo = true;
            }
            if (!values.contains(6) && !values.contains(7) && !values.contains(8) && !values.contains(9)) {
                count++;
                foundAisleCombo = true;
            }
            if (!foundAisleCombo && !values.contains(4) && !values.contains(5) && !values.contains(6) && !values.contains(7)) {
                count++;
            }
        }

        return count;
    }
}

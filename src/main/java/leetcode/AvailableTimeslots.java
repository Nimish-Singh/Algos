package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Given 2 lists (unsorted and unmerged) representing the time slots when 2 persons have booked calendars, return a list
of time slots when both of them are simultaneously "available" (ie., don't have anything scheduled)
 */
public class AvailableTimeslots {
    public List<List<Integer>> findAvailableSlots(List<List<Integer>> person1OccupiedSlots, List<List<Integer>> person2OccupiedSlots) {
        // No need to merge individual intervals, since that'll also happen after combining
//        List<List<Integer>> mergedPerson1Slots = mergeSlots(person1OccupiedSlots);
//        List<List<Integer>> mergedPerson2Slots = mergeSlots(person2OccupiedSlots);
//        List<List<Integer>> combinedSlots = new ArrayList<>(mergedPerson1Slots);
//        combinedSlots.addAll(mergedPerson2Slots);

        List<List<Integer>> combinedSlots = new ArrayList<>(person1OccupiedSlots);
        combinedSlots.addAll(person2OccupiedSlots);
        List<List<Integer>> mergedSlotsForBoth = mergeSlots(combinedSlots);

        List<List<Integer>> availableSlots = new ArrayList<>();
        for (int index = 0; index < mergedSlotsForBoth.size() - 1; index++) {
            availableSlots.add(Arrays.asList(mergedSlotsForBoth.get(index).get(1), mergedSlotsForBoth.get(index + 1).get(0)));
        }

        if (mergedSlotsForBoth.isEmpty()) {
            availableSlots.add(Arrays.asList(0, 24));
            return availableSlots;
        }

        if (mergedSlotsForBoth.get(0).get(0) != 0) {
            availableSlots.add(0, Arrays.asList(0, mergedSlotsForBoth.get(0).get(0)));
        }
        if (mergedSlotsForBoth.get(mergedSlotsForBoth.size() - 1).get(1) != 24) {
            availableSlots.add(Arrays.asList(mergedSlotsForBoth.get(mergedSlotsForBoth.size() - 1).get(1), 24));
        }

        return availableSlots;
    }

    private List<List<Integer>> mergeSlots(List<List<Integer>> slots) {
        slots.sort(Comparator.comparingInt(a -> a.get(0)));
        LinkedList<List<Integer>> mergedList = new LinkedList<>();

        for (List<Integer> slot : slots) {
            if (mergedList.isEmpty() || mergedList.getLast().get(1) < slot.get(0)) {
                mergedList.add(slot);
            } else {
                mergedList.getLast().set(1, Math.max(mergedList.getLast().get(1), slot.get(1)));
            }
        }
        return mergedList;
    }
}

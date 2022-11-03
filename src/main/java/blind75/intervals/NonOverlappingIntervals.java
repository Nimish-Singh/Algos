package blind75.intervals;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int count = 0, previousEnd = intervals[0][1];
        for (int index = 1; index < intervals.length; index++) {
            if (previousEnd <= intervals[index][0]) {
                previousEnd = intervals[index][1];
                continue;
            }
            previousEnd = Math.min(previousEnd, intervals[index][1]);
            count++;
        }
        return count;
    }
}

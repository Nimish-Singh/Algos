package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
public class GridCutSections {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] alongYAxis = new int[rectangles.length][2];
        int[][] alongXAxis = new int[rectangles.length][2];

        for (int index = 0; index < rectangles.length; index++) {
            int[] rectangle = rectangles[index];

            alongYAxis[index] = new int[]{rectangle[1], rectangle[3]};
            alongXAxis[index] = new int[]{rectangle[0], rectangle[2]};
        }

        if (isMergedAlongAxis(n, alongYAxis)) {
            return true;
        }

        return isMergedAlongAxis(n, alongXAxis);
    }

    private boolean isMergedAlongAxis(int n, int[][] lengthsAlongAxis) {
        Arrays.sort(lengthsAlongAxis, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();

        mergedIntervals.add(new int[]{lengthsAlongAxis[0][0], lengthsAlongAxis[0][1]});
        int listIndex = 0;
        for (int index = 1; index < lengthsAlongAxis.length; index++) {
            int[] currInterval = mergedIntervals.get(listIndex);

            if (currInterval[1] > lengthsAlongAxis[index][0]) {
                currInterval[1] = Math.max(currInterval[1], lengthsAlongAxis[index][1]);
            } else {
                mergedIntervals.add(new int[]{lengthsAlongAxis[index][0], lengthsAlongAxis[index][1]});
                listIndex++;
            }
        }

        return mergedIntervals.size() >= 3;
    }
}

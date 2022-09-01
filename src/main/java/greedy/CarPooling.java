package greedy;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/car-pooling/
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] pickUps = new int[trips.length][2];
        int[][] dropOffs = new int[trips.length][2];

        for (int index = 0; index < trips.length; index++) {
            pickUps[index] = new int[]{trips[index][0], trips[index][1]};
            dropOffs[index] = new int[]{trips[index][0], trips[index][2]};
        }

        Arrays.sort(pickUps, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(dropOffs, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int pax = 0, pickUpIndex = 0, dropOffIndex = 0;

        for (int location = pickUps[0][1]; location < dropOffs[dropOffs.length - 1][1]; location++) {
            if (location == dropOffs[dropOffIndex][1]) {
                while (location == dropOffs[dropOffIndex][1]) {
                    pax -= dropOffs[dropOffIndex][0];
                    dropOffIndex++;
                }
            }
            if (pickUpIndex < pickUps.length && location == pickUps[pickUpIndex][1]) {
                while (pickUpIndex < pickUps.length && location == pickUps[pickUpIndex][1]) {
                    if (pax + pickUps[pickUpIndex][0] > capacity)
                        return false;
                    pax += pickUps[pickUpIndex][0];
                    pickUpIndex++;
                }
            }
        }
        return true;
    }
}

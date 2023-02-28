package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
public class Merge2DArraysWithSums {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] answer = new int[nums1.length + nums2.length][2];

        int index1 = 0, index2 = 0, totalElements = 0;

        // fill common elements sum
        // fill remaining elements from one of the remaining array
        // remove unnecessary last elements, until totalElements

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1][0] == nums2[index2][0]) {
                answer[totalElements][0] = nums1[index1][0];
                answer[totalElements][1] = nums1[index1][1] + nums2[index2][1];
                index1++;
                index2++;
                totalElements++;
                continue;
            }
            if (nums1[index1][0] < nums2[index2][0]) {
                answer[totalElements][0] = nums1[index1][0];
                answer[totalElements][1] = nums1[index1][1];
                index1++;
            } else {
                answer[totalElements][0] = nums2[index2][0];
                answer[totalElements][1] = nums2[index2][1];
                index2++;
            }
            totalElements++;
        }

        while (index1 < nums1.length) {
            answer[totalElements][0] = nums1[index1][0];
            answer[totalElements][1] = nums1[index1][1];
            totalElements++;
            index1++;
        }
        while (index2 < nums2.length) {
            answer[totalElements][0] = nums2[index2][0];
            answer[totalElements][1] = nums2[index2][1];
            totalElements++;
            index2++;
        }

        return Arrays.copyOf(answer, totalElements);
    }
}

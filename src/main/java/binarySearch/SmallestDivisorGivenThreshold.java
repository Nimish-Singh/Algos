package binarySearch;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class SmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        /*
        smallest possible divisor is 1
        largest possible divisor is max number in the array

        We have to find smallest possible which divides and sum goes under given threshold
            If sum doesnt go over threshold at end of array -> move right to mid - 1
            If sum goes over threshold -> move left to mid + 1
                return left all the time (smallest possible)
         */

        int max = -1;
        for (int num : nums)
            max = Math.max(max, num);

        int left = 1, right = max;

        while (left <= right) {
            int mid = (left + right) / 2;

            int divisionSum = 0;
            for (int num : nums) {
                int quotient = num / mid;
                divisionSum += quotient;
                if (num % mid != 0) {
                    divisionSum++;
                }
            }

            if (divisionSum > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

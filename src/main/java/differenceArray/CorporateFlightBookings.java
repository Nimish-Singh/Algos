package differenceArray;

// Important
// https://leetcode.com/problems/corporate-flight-bookings/description/
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        for (int[] b : bookings) {
            int rangeStart = b[0];
            int rangeEnd = b[1];
            int seats = b[2];

            answer[rangeStart - 1] += seats;

            if (rangeEnd < n) {
                answer[rangeEnd] -= seats;
            }
        }

        for (int index = 1; index < n; index++)
            answer[index] += answer[index - 1];

        return answer;
    }
}

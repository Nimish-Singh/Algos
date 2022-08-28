package dynamicProgramming;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class MinTicketsCost {
    public int mincostTickets(int[] days, int[] costs) {
//        return recursiveHelper(days, 0, days.length - 1, costs);
        int[] minCosts = new int[days.length];
        return topDown(days, 0, days.length - 1, costs, minCosts);
//        return bottomUp(days, costs);
    }

    private int bottomUp(int[] days, int[] costs) {
        int lastTravelDay = days[days.length - 1];
        boolean[] isTravelDay = new boolean[lastTravelDay + 1];

        for (int day: days) {
            isTravelDay[day] = true;
        }

        int[] minCosts = new int[lastTravelDay + 1];
        minCosts[0] = 0;

        for (int index = 1; index <= lastTravelDay; index++) {
            if (!isTravelDay[index]) {
                minCosts[index] = minCosts[index - 1];
                continue;
            }

            int oneDayTicketCost = costs[0] + minCosts[Math.max(0, index - 1)];
            int sevenDayTicketCost = costs[1] + minCosts[Math.max(0, index - 7)];
            int thirtyDayTicketCost = costs[2] + minCosts[Math.max(0, index - 30)];

            minCosts[index] = Math.min(oneDayTicketCost, Math.min(sevenDayTicketCost, thirtyDayTicketCost));
        }

        return minCosts[minCosts.length - 1];
    }

    private int topDown(int[] days, int startIndex, int endIndex, int[] costs, int[] minCosts) {
        if (startIndex > endIndex)
            return 0;

        if (minCosts[startIndex] != 0) {
            return minCosts[startIndex];
        }

        int oneDayTicketCost = costs[0] + topDown(days, startIndex + 1, endIndex, costs, minCosts);

        int newStartIndexForSeven = startIndex;
        while (newStartIndexForSeven <= endIndex && days[newStartIndexForSeven] <= days[startIndex] + 6)
            newStartIndexForSeven++;

        int sevenDayTicketCost = costs[1] + topDown(days, newStartIndexForSeven, endIndex, costs, minCosts);

        int newStartIndexForThirty = startIndex;
        while (newStartIndexForThirty <= endIndex && days[newStartIndexForThirty] <= days[startIndex] + 29)
            newStartIndexForThirty++;

        int thirtyDayTicketCost = costs[2] + topDown(days, newStartIndexForThirty, endIndex, costs, minCosts);

        minCosts[startIndex] = Math.min(oneDayTicketCost, Math.min(sevenDayTicketCost, thirtyDayTicketCost));
        return minCosts[startIndex];
    }

    private int recursiveHelper(int[] days, int startIndex, int endIndex, int[] costs) {
        if (startIndex > endIndex)
            return 0;

        int oneDayTicketCost = costs[0] + recursiveHelper(days, startIndex + 1, endIndex, costs);

        int newStartIndexForSeven = startIndex;
        while (newStartIndexForSeven <= endIndex && days[newStartIndexForSeven] <= days[startIndex] + 6)
            newStartIndexForSeven++;

        int sevenDayTicketCost = costs[1] + recursiveHelper(days, newStartIndexForSeven, endIndex, costs);

        int newStartIndexForThirty = startIndex;
        while (newStartIndexForThirty <= endIndex && days[newStartIndexForThirty] <= days[startIndex] + 29)
            newStartIndexForThirty++;

        int thirtyDayTicketCost = costs[2] + recursiveHelper(days, newStartIndexForThirty, endIndex, costs);

        return Math.min(oneDayTicketCost, Math.min(sevenDayTicketCost, thirtyDayTicketCost));
    }
}

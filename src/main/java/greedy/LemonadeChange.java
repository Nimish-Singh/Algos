package greedy;

// https://leetcode.com/problems/lemonade-change/
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] billCounts = new int[2];
        // billCounts[0] = $5 count; billCounts[1] = $10 count;

        for (int bill : bills) {
            if (bill == 5) {
                billCounts[0]++;
                continue;
            }

            if (bill == 10) {
                if (billCounts[0] > 0) {
                    billCounts[0]--;
                    billCounts[1]++;
                    continue;
                }
                return false;
            }

            if (billCounts[1] > 0 && billCounts[0] > 0) {
                billCounts[1]--;
                billCounts[0]--;
                continue;
            }
            if (billCounts[0] > 2) {
                billCounts[0] -= 3;
                continue;
            }
            return false;
        }
        return true;
    }
}

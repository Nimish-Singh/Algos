package leetcode;

// https://leetcode.com/problems/gas-station/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;

        for (int index = 0; index < gas.length; index++) {
            totalGas += gas[index] - cost[index];
        }

        if (totalGas < 0)
            return -1;

        int gasAcc = 0, startIndex = 0;

        for (int index = 0; index < gas.length; index++) {
            gasAcc += gas[index] - cost[index];

            if (gasAcc < 0) {
                gasAcc = 0;
                startIndex = index + 1;
            }
        }

        return startIndex;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/
public class MakeArraysSimilar {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        List<Integer> evenNums = new ArrayList<>();
        List<Integer> oddNums = new ArrayList<>();
        List<Integer> evenTargets = new ArrayList<>();
        List<Integer> oddTargets = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0)
                evenNums.add(num);
            else
                oddNums.add(num);
        }

        for (int targNum : target) {
            if (targNum % 2 == 0)
                evenTargets.add(targNum);
            else
                oddTargets.add(targNum);
        }

        long minOps = 0;

        for (int index = 0; index < oddNums.size(); index++) {
            if (oddNums.get(index) > oddTargets.get(index))
                minOps += (oddNums.get(index) - oddTargets.get(index)) / 2;
        }

        for (int index = 0; index < evenNums.size(); index++) {
            if (evenNums.get(index) > evenTargets.get(index))
                minOps += (evenNums.get(index) - evenTargets.get(index)) / 2;
        }
        return minOps;
    }
}

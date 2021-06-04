package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] strNums = new String[nums.length];

        IntStream.range(0, nums.length).forEach(index -> strNums[index] = String.valueOf(nums[index]));

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].charAt(0) == '0')
            return "0";

        StringBuilder answer = new StringBuilder("");
        IntStream.range(0, strNums.length).forEach(index -> answer.append(strNums[index]));
        return answer.toString();
    }
}

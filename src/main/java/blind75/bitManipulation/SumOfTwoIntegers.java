package blind75.bitManipulation;

// https://leetcode.com/problems/sum-of-two-integers/
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        // https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
        // and https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation for line 13
        int carry;

        while (b != 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

package leetcode;

// https://leetcode.com/problems/k-items-with-the-maximum-sum/description/
public class KItemsWithMaxSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        if (k <= (numOnes + numZeros)) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }
}

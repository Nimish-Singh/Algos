package leetcode;

// https://leetcode.com/problems/prime-in-diagonal/description/
public class PrimeInDiagonal {
    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        for (int index = 0; index < nums.length; index++) {
            int primaryDiagonalElement = nums[index][index];

            if (isPrime(primaryDiagonalElement)) {
                maxPrime = Math.max(maxPrime, primaryDiagonalElement);
            }

            int secondaryDiagonalElement = nums[index][nums.length - index - 1];

            if (isPrime(secondaryDiagonalElement)) {
                maxPrime = Math.max(maxPrime, secondaryDiagonalElement);
            }
        }

        return maxPrime;
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int factor = 2; factor <= Math.sqrt(number); factor++) {
            if (number % factor == 0)
                return false;
        }
        return true;
    }
}

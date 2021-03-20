package xor;

// For a given positive number in base-10, return the complement of its binary representation as a base-10 integer
public class Base10Compliment {
    public int find(int number) {
        int bitCount = 0, n = number;
        while (n > 0) {
            bitCount++;
            n >>= 1;
        }

        int numberWithAllOnes = (int) Math.pow(2, bitCount) - 1;

        return number ^ numberWithAllOnes;
    }
}

package leetcode;

// https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/
public class MakeIntegerBeautiful {
    public long makeIntegerBeautiful(long n, int target) {
//        return bruteForce(n, target);
        return optimised(n, target);
    }

    // https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/discuss/2758230/Java-solution-with-explanation-and-example-increment-by-the-next-power-of-10
    private long optimised(long n, int target) {
        long nCopy = n, beautyNumber = n;
        int digitSum = getSumOfDigits(nCopy), round = 1;
        if (digitSum <= target){
            return 0;
        }

        while (digitSum > target){
            nCopy /= 10;
            beautyNumber = (long) ((nCopy + 1) * Math.pow(10, round));
            digitSum = getSumOfDigits(beautyNumber);
            round++;
        }
        return beautyNumber - n;
    }

    private long bruteForce(long n, int target) {
        long answer = 0;
        do {
            int sumOfDigits = getSumOfDigits(n + answer);
            if (sumOfDigits <= target)
                return answer;
            answer++;
        } while (true);
    }

    private int getSumOfDigits(long number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

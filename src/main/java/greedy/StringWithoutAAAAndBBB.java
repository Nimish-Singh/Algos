package greedy;

// https://leetcode.com/problems/string-without-aaa-or-bbb/
public class StringWithoutAAAAndBBB {
    public String strWithout3a3b(int a, int b) {
        int largerNumber = a, smallerNumber = b;
        char largerLetter = 'a', smallerLetter = 'b';

        if (b > a) {
            largerNumber = b;
            largerLetter = 'b';
            smallerNumber = a;
            smallerLetter = 'a';
        }

        StringBuilder answer = new StringBuilder(a + b);

        while (largerNumber > 0) {
            largerNumber--;
            answer.append(largerLetter);

            if (largerNumber > smallerNumber) {
                answer.append(largerLetter);
                largerNumber--;
            }
            if (smallerNumber > 0) {
                smallerNumber--;
                answer.append(smallerLetter);
            }
        }

        return answer.toString();
    }
}

package leetcode;

// https://leetcode.com/problems/pass-the-pillow/description/
public class PassThePillow {
    public int passThePillow(int n, int time) {
        boolean leftToRight = (time / (n - 1)) % 2 == 0;

        if (leftToRight) {
            return (time % (n - 1)) + 1;
        }
        return n - (time % (n - 1));
    }
}

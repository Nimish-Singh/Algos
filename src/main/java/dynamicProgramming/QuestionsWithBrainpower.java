package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/solving-questions-with-brainpower/
public class QuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
//        return recursive(questions, 0);

        long[] memo = new long[questions.length];
        Arrays.fill(memo, -1);
        return topDown(questions, 0, memo);

//        return bottomUp(questions);
    }

    private long bottomUp(int[][] questions) {
        int length = questions.length;
        long[] memo = new long[length];
        memo[length - 1] = questions[length - 1][0];

        for (int index = length - 2; index >= 0; index--) {
            long onSolvingThisQuestion = questions[index][0];
            if (index + questions[index][1] + 1 < length)
                onSolvingThisQuestion += memo[index + questions[index][1] + 1];
            long onSkippingThisQuestion = memo[index + 1];
            memo[index] = Math.max(onSolvingThisQuestion, onSkippingThisQuestion);
        }
        return memo[0];
    }

    private long topDown(int[][] questions, int index, long[] memo) {
        if (index >= questions.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        long onSolvingThisQuestion = questions[index][0] + topDown(questions, index + questions[index][1] + 1, memo);
        long onSkippingThisQuestion = topDown(questions, index + 1, memo);

        memo[index] = Math.max(onSolvingThisQuestion, onSkippingThisQuestion);
        return memo[index];
    }

    private long recursive(int[][] questions, int index) {
        if (index >= questions.length)
            return 0;

        long onSolvingThisQuestion = questions[index][0] + recursive(questions, index + questions[index][1] + 1);
        long onSkippingThisQuestion = recursive(questions, index + 1);

        return Math.max(onSolvingThisQuestion, onSkippingThisQuestion);
    }
}

package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBST {
    // https://leetcode.com/problems/unique-binary-search-trees/solutions/31696/simple-recursion-java-solution-with-explanation/
    public int numTrees(int n) {
//        return recursive(n);

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return topDown(n, memo);

//        return bottomUp(n);
    }

    // https://leetcode.com/problems/unique-binary-search-trees/solutions/3714210/java-recursive-memoization-and-tabulation-method/
    private int bottomUp(int nodes) {
        int[] memo = new int[nodes + 1];

        memo[0] = 1;
        memo[1] = 1;

        for (int node = 2; node <= nodes; node++)
            for (int root = 1; root <= node; root++)
                memo[node] += memo[root - 1] * memo[node - root];

        return memo[nodes];
    }

    private int topDown(int nodes, int[] memo) {
        if (nodes <= 1)
            return 1;

        if (memo[nodes] != -1)
            return memo[nodes];

        int answer = 0;
        for (int node = 1; node <= nodes; node++)
            answer += topDown(node - 1, memo) * topDown(nodes - node, memo);
        memo[nodes] = answer;
        return answer;
    }

    private int recursive(int nodes) {
        if (nodes <= 1)
            return 1;

        int answer = 0;
        for (int node = 1; node <= nodes; node++)
            answer += recursive(node - 1) * recursive(nodes - node);
        return answer;
    }
}

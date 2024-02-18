package leetcode;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
public class LevelAverages {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Double> answer = new LinkedList();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            Double average = 0.0;
            for (int node = 0; node < nodesInCurrentLevel; node++) {
                TreeNode n = queue.poll();
                average += n.val;

                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            answer.add(average/nodesInCurrentLevel);
        }
        return answer;
    }
}

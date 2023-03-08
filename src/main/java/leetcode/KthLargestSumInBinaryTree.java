package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
public class KthLargestSumInBinaryTree {
    // O(n + nlogk)
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> nodes = new LinkedList<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        nodes.offer(root);

        while (!nodes.isEmpty()) {
            int currLevelNodes = nodes.size();
            long levelSum = 0;
            for (int i = 0; i < currLevelNodes; i++) {
                TreeNode node = nodes.poll();
                levelSum += node.val;
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            if (minHeap.size() < k) {
                minHeap.offer(levelSum);
            } else {
                if (minHeap.peek() < levelSum) {
                    minHeap.poll();
                    minHeap.offer(levelSum);
                }
            }
        }

        return minHeap.size() < k ? -1 : minHeap.poll();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

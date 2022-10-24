package blind75.tree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class TreeFromOrderTraversal {
    private Map<Integer, Integer> valueIndexMap;
    private int preorderIndex;

    public TreeFromOrderTraversal() {
        valueIndexMap = new HashMap<>();
        preorderIndex = 0;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        for (int index = 0; index < inorder.length; index++) {
            valueIndexMap.put(inorder[index], index);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int leftIndex, int rightIndex) {
        if (preorderIndex >= preorder.length || leftIndex > rightIndex)
            return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = helper(preorder, leftIndex, valueIndexMap.get(rootValue) - 1);
        root.right = helper(preorder, valueIndexMap.get(rootValue) + 1, rightIndex);

        return root;
    }
}

package solutions.hard.again;

public class BinaryTreeMaximumPathSum {

    // https://leetcode.com/problems/binary-tree-maximum-path-sum/
    // Able to solve 65% with successive hints by GPT without seeing code
    // To see why Integer or int couldn't be used check replies to user hyuna915 in top Java solution
    // https://www.youtube.com/watch?v=WszrfSwMz58
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int globalMax = Integer.MIN_VALUE;  // Imagine if -10 is the only node

    public int maxPathSum(TreeNode root) {
        postOrderTraverse(root);
        return globalMax;
    }

    private int postOrderTraverse(TreeNode treeNode){
        if (treeNode == null) return 0;

        int leftNum = Math.max(0, postOrderTraverse(treeNode.left));
        int rightNum = Math.max(0, postOrderTraverse(treeNode.right));

        globalMax = Math.max(globalMax, leftNum + rightNum + treeNode.val);

        return Math.max(leftNum, rightNum) + treeNode.val;
    }
}

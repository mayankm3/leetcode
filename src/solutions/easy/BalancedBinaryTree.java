package solutions.easy;

public class BalancedBinaryTree {

    // https://leetcode.com/problems/balanced-binary-tree/description/
    // https://www.youtube.com/watch?v=Yt50Jfbd8Po
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

    public boolean isBalanced(TreeNode root) {
        return dfsHeightDifference(root) != -1;
    }

    private int dfsHeightDifference(TreeNode treeNode){
        if (treeNode == null) return 0;

        int leftHeight = dfsHeightDifference(treeNode.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeightDifference(treeNode.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight-rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

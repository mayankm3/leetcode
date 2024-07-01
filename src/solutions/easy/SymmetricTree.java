package solutions.easy;

public class SymmetricTree {

    // https://leetcode.com/problems/symmetric-tree/
    // TC: O(n) We need to visit each node once to check if the tree is symmetric
    // SC: O(h) where h is the height of the binary tree. In the worst case, the tree can be completely unbalanced, and
    // the recursion stack can go as deep as the height of the tree.
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

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode tLeft, TreeNode tRight){
        if(tLeft==null && tRight==null) return true;
        if(tLeft==null || tRight==null) return false;
        if(tLeft.val != tRight.val) return false;
        return helper(tLeft.left, tRight.right) && helper(tLeft.right, tRight.left);
    }


}

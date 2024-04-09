package solutions.medium.again;

import javax.swing.tree.TreeNode;

public class ValidateBinarySearchTree {

    // https://leetcode.com/problems/validate-binary-search-tree
    // https://leetcode.com/problems/validate-binary-search-tree/solutions/32109/my-simple-java-solution-in-3-lines/
    // https://www.youtube.com/watch?v=f-sj7I5oXEI You didn't understand the solution in the first place. Revise.
    // This solution is DFS
    // TC: O(n)
    // SC: O(1) + auxiliary stack space
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode treeNode, long minVal, long maxVal){
        if (treeNode==null) return true;

        if (treeNode.val<=minVal || treeNode.val>=maxVal) return false;

        return isValidBST(treeNode.left, minVal, treeNode.val) && isValidBST(treeNode.right, treeNode.val, maxVal);
    }
}

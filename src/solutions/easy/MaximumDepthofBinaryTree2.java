package solutions.easy;

public class MaximumDepthofBinaryTree2 {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree
    // Basically total levels
    // Recursively ( Post Order Traversal )
    // Time Complexity: O(N)
    // Space Complexity: O(1) Extra Space + O(H) Recursion Stack space, where “H”  is the height of the binary tree
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

    public int maxDepth(TreeNode root) {
        if(root==null) return  0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

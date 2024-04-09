package solutions.medium.again;

public class KthSmallestElementinaBST1 {

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst
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

    // It's not a normal tree, it's a BST- Binary Search Tree!!!
    int k, result;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if(root==null) return;

        inorder(root.left);

        if(--k == 0){
            result = root.val;
            return;
        }

        inorder(root.right);
    }


}

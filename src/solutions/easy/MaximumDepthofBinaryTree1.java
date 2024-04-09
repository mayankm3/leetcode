package solutions.easy;

public class MaximumDepthofBinaryTree1 {

    // My solution
    // https://leetcode.com/problems/maximum-depth-of-binary-tree
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
        int maxNodes = 0;
        return marianaTrench(root, maxNodes);
    }

    private int marianaTrench(TreeNode treeNode, int countOfNodes) {
        countOfNodes += 1;
        int leftCount = 0, rightCount = 0;
        if (treeNode.left == null && treeNode.right == null) return countOfNodes;
        if (treeNode.left != null){
            leftCount = marianaTrench(treeNode.left, countOfNodes);
        }
        if (treeNode.right != null) {
            rightCount = marianaTrench(treeNode.right, countOfNodes);
        }

        return leftCount>=rightCount ? leftCount:rightCount;
    }
}

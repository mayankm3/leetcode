package solutions.easy.again;

public class DiameterofBinaryTree {

    // https://leetcode.com/problems/diameter-of-binary-tree/
    // Basically count number of edges on the left & right of root
    // https://leetcode.com/problems/diameter-of-binary-tree/solutions/101132/java-solution-maxdepth/
    // https://www.youtube.com/watch?v=Rezetez59Nk It's not necessary that the longest path is passing from root node :)
    // Time Complexity: O(N)
    // Space Complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree). O(n)
    // if tree is skewed.
    int currLongestDiameter;
    private class TreeNode {
        int val;
        DiameterofBinaryTree.TreeNode left;
        DiameterofBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, DiameterofBinaryTree.TreeNode left, DiameterofBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return currLongestDiameter;
    }

    private int maxDepth(TreeNode tNode) {
        if (tNode==null) return 0;

        int left = maxDepth(tNode.left);
        int right = maxDepth(tNode.right);

        currLongestDiameter = Math.max(currLongestDiameter, left+right);

        return Math.max(left, right)+1;
    }
}

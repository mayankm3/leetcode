package solutions.medium.again;

public class LowestCommonAncestorOfABinaryTree {

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    // https://www.youtube.com/watch?v=WRAJ8Q9bICM
    // https://www.youtube.com/watch?v=_-QHfMDde90
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        else {
            return root;
        }

        // or we can do below
//        if (leftNode != null && rightNode != null) return root;
//        else {
//            return leftNode != null ? leftNode : rightNode;
//        }
    }
}

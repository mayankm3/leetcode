package solutions.easy.again;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree1 {

    // https://leetcode.com/problems/invert-binary-tree
    // Good attempt
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

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode result = new TreeNode();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()){
            int count = treeNodeQueue.size();

            for (int i = 0; i < count; i++) {
                TreeNode aNode = treeNodeQueue.poll();
                result.val = aNode.val;

                if (aNode.right!=null){
                    treeNodeQueue.add(aNode.right);
                    result.left = aNode.right;
                }
                if (aNode.left!=null){
                    treeNodeQueue.add(aNode.left);
                    result.right = aNode.left;
                }
            }
        }

        return result;
    }

}

package solutions.easy.again;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree2 {

    // https://leetcode.com/problems/invert-binary-tree
    // https://leetcode.com/problems/invert-binary-tree/solutions/62707/straightforward-dfs-recursive-iterative-bfs-solutions/
    // BFS- level order traversal
    // https://www.youtube.com/watch?v=ck23lNqbLjI
    // Time Complexity : O(n)
    // Space Complexity : O(n). (But why? At max there can be 2 elements in the Queue...? So why not O(1)?)
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

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()){
            TreeNode aNode = treeNodeQueue.poll();
            TreeNode tempLeft = aNode.left;
            aNode.left = aNode.right;
            aNode.right = tempLeft;

            if (aNode.left!=null){
                treeNodeQueue.add(aNode.left);
            }
            if (aNode.right!=null){
                treeNodeQueue.add(aNode.right);
            }
        }

        return root;
    }

}

package solutions.medium.again;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // The time complexity is O(n)
    // The worst space complexity is O(n) since in a prefect binary tree we can have n/2 nodes at the deepest level
    // and best is O(1)
    // https://youtu.be/86g8jAQug04?&t=515
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    // https://www.youtube.com/watch?v=6ZnyEApgFYg
    // https://www.youtube.com/watch?v=vQrggrFMyp8

    private static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        // If you check size here, System.out.println("Size of queue: "+treeNodeQueue.size());, then you will find out
        // that the size is one, which means we added only 1 node to the queue and not the whole tree.

        while (!treeNodeQueue.isEmpty()){
            int count = treeNodeQueue.size();
            List<Integer> level = new ArrayList<>(count);

            for (int i = 0; i < count; i++) {
                TreeNode aNode = treeNodeQueue.poll();  // Retrieves and removes
                level.add(aNode.val);
                if(aNode.left != null){
                    treeNodeQueue.add(aNode.left);
                }
                if(aNode.right != null){
                    treeNodeQueue.add(aNode.right);
                }
            }

            res.add(level);
        }

        return res;
    }

}

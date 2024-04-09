package solutions.medium.again;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    // https://leetcode.com/problems/binary-tree-right-side-view/description
    // https://leetcode.com/problems/binary-tree-right-side-view/solutions/56076/reverse-level-order-traversal-java/
    // See the first reply in above link
    // This problem has a DFS solution as well
    // You didn't think about below case :)
    // Input: 10 20 30 40 60
    //      10
    //     /   \
    //   20     30
    //  /   \
    // 40  60
    // Output: 10 30 60

    // TC: O(n) because we traverse all n nodes in the tree once
    // SC: O(n+m) because the queue will contain up to n nodes and the resultant right side view list will contain m nodes.
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root==null) return result;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()){
            int queueSize = treeNodeQueue.size();   // level size

            for (int i = 0; i < queueSize; i++) {
                TreeNode aNode = treeNodeQueue.poll();
                if (i == queueSize-1) result.add(aNode.val);
                if (aNode.left!=null) treeNodeQueue.add(aNode.left);
                if (aNode.right!=null) treeNodeQueue.add(aNode.right);
            }
        }

        return result;
    }
}

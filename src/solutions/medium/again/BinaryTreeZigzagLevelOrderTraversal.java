package solutions.medium.again;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/33815/my-accepted-java-solution/
    // See wfei26's solution from above link
    // https://www.youtube.com/watch?v=3OXWEdlIGl4 Diagram was instrumental in understanding this solution
    // TC: O(n)
    // SC: O(n)
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listOfList = new ArrayList<>();

        if (root==null) return listOfList;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        boolean bitFlip = false;    // false, true, false,...

        while (!treeNodeQueue.isEmpty()){
            int currQueueSize = treeNodeQueue.size();
            LinkedList<Integer> tempIntList = new LinkedList<>();

            for (int i = 0; i < currQueueSize; i++) {
                TreeNode aNode = treeNodeQueue.poll();

                if (bitFlip){
                    tempIntList.addFirst(aNode.val);    // Whenever executed every element is added to the beginning
                }
                else {
                    tempIntList.add(aNode.val); // New element is appended to the end
                }

                if (aNode.left!=null) treeNodeQueue.offer(aNode.left);
                if (aNode.right!=null) treeNodeQueue.offer(aNode.right);
            }
            bitFlip = !bitFlip;

            listOfList.add(tempIntList);
        }

        return listOfList;
    }

}

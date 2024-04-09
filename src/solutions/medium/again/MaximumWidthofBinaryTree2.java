package solutions.medium.again;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree2 {

    // https://leetcode.com/problems/maximum-width-of-binary-tree/
    // https://leetcode.com/problems/maximum-width-of-binary-tree/solutions/3436680/java-easy-image-explaination-level-order-beginner-friendly/
    // This solution is BFS
    // Time complexity: O(n) since we are iterating over all the elements of the tree once.
    // Space complexity: O(n) at max we can have n elements in queue.
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

    private class Node{
        TreeNode treeNode;
        int indexOnLevel = 0;

        public Node(TreeNode tN, int iOL){
            this.treeNode = tN;
            this.indexOnLevel = iOL;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queueOfNode = new LinkedList<>();
        queueOfNode.offer(new Node(root, 0));

        int width = 0;

        while (!queueOfNode.isEmpty()){
            int queueSize = queueOfNode.size();

            int start = 0, end = 0;

            for (int i = 0; i < queueSize; i++) {
                Node aNode = queueOfNode.poll();
                int index = aNode.indexOnLevel;

                if (i == 0){
                    start = index;  // set start at leftmost non-null
                }
                if (i == queueSize-1){
                    end = index;    //   // set end at rightmost non-null
                }

                if (aNode.treeNode.left!=null){
                    queueOfNode.offer(new Node(aNode.treeNode.left, 2*aNode.indexOnLevel));
                }
                if (aNode.treeNode.right!=null){
                    queueOfNode.offer(new Node(aNode.treeNode.right, 2*aNode.indexOnLevel+1));
                }
            }

            width = Math.max(width, end-start+1);
        }

        return width;
    }
}

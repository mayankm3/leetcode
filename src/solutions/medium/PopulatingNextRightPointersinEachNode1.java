package solutions.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode1 {


    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node
    // My own solution. Solved on the basis of class BinaryTreeRightSideView
    // Time Complexity : O(N)
    // Space Complexity : O(W) = O(N), where W is the width of given tree. This is required to store the nodes in queue.

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null) return root;

        Queue<Node> queueOfNodes = new LinkedList<>();
        queueOfNodes.offer(root);

        while (!queueOfNodes.isEmpty()){
            int levelSize = queueOfNodes.size();

            for (int i = 0; i < levelSize; i++) {
                Node aNode = queueOfNodes.poll();

                if(i == levelSize-1) {
                    aNode.next = null;
                }
                else {
                    aNode.next = queueOfNodes.peek();
                }

                if(aNode.left!=null) queueOfNodes.add(aNode.left);
                if(aNode.right!=null) queueOfNodes.add(aNode.right);

                 /*Since the tree is perfect thus we can also do below
                if(aNode.left!=null) {
                    queueOfNodes.add(aNode.left);
                    queueOfNodes.add(aNode.right);
                }*/

            }
        }

        return root;
    }
}

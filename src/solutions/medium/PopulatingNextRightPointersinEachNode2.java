package solutions.medium;

public class PopulatingNextRightPointersinEachNode2 {


    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solutions/1654181/c-python-java-simple-solution-w-images-explanation-bfs-dfs-o-1-optimized-bfs/
    // Time Complexity : O(N), we only traverse each node once
    // Space Complexity : O(1)
    // This performs better than my previous solutions

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
        Node head = root;

        for (; root!=null ; root=root.left) {   // The 3rd condition in for loops is evaluated after current iteration ends :)

            for (Node curr = root; curr!=null; curr=curr.next) {   // // The 3rd condition in for loops is evaluated after current iteration ends :)
                if (curr.left!=null){
                    curr.left.next = curr.right;
                    if (curr.next!=null) curr.right.next = curr.next.left;
                }
                else break;
            }
        }

        return head;
    }
}

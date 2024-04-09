package solutions.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph2 {

    // https://leetcode.com/problems/clone-graph/description/
    // Time Complexity: O(N) where N is no. of nodes in our graph
    // Space Complexity: O(N). Since we are making copies of each and every node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node==null) return null;
        return dfSearch(node, new HashMap<>());
    }

    private Node dfSearch(Node original, HashMap<Node, Node> visited) {
        if (visited.containsKey(original)){
            return visited.get(original);   // returns only the clone
        }

        Node copy = new Node(original.val); // create a new node if not present in Map
        visited.put(original, copy);

        for (Node node:original.neighbors) {
            copy.neighbors.add(dfSearch(node, visited));
        }

        return copy;
    }
}

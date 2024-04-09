package solutions.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {

    // https://leetcode.com/problems/clone-graph/description/

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
        if (node==null || node.neighbors.size()==0) return node;

        Node result = new Node();

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(node.val);

        dfSearch(node, result, hashSet);

        return result;
    }

    private void dfSearch(Node question, Node answer, HashSet<Integer> integerHashSet) {
        List<Node> padosis = question.neighbors;
        List<Node> duplicate = new ArrayList<>(padosis.size());

        for (Node padosi:padosis){

            int padosiValue = padosi.val;

            if (!integerHashSet.contains(padosiValue)) {
                integerHashSet.add(padosiValue);
                dfSearch(padosi, answer, integerHashSet);

                answer.val = padosiValue;
            }

            duplicate.add(padosi);
        }

        answer.neighbors = duplicate;
    }


}

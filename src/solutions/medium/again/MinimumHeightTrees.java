package solutions.medium.again;

import java.util.*;

public class MinimumHeightTrees {

    // https://leetcode.com/problems/minimum-height-trees/description/
    // https://leetcode.com/problems/minimum-height-trees/solutions/76055/share-some-thoughts/
    // https://www.youtube.com/watch?v=ivl6BHJVcB0

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int[][] arr1 = {{3,0},{3,1},{3,2},{3,4},{5,4},{3,6},{6,7},{7,8}};
        System.out.println(minimumHeightTrees.findMinHeightTrees(9, arr1));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==1) return Collections.singletonList(0);

        List<Set<Integer>> adjTree = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjTree.add(new HashSet<>());
        }

        for (int[] pair:edges) {
            adjTree.get(pair[0]).add(pair[1]);
            adjTree.get(pair[1]).add(pair[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int degree = adjTree.get(i).size();
            if (degree==1) leaves.add(i);   // inserting nodes with degree 1
        }

        while (n>2){    // there can be only 1 or 2 roots
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf:leaves) {
                int parent = adjTree.get(leaf).iterator().next();
                adjTree.get(parent).remove(leaf);  // removing until we have either 1 or 2 nodes

                if (adjTree.get(parent).size() == 1) newLeaves.add(parent);
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}

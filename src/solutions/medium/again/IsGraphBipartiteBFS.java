package solutions.medium.again;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteBFS {

    // TC: O(V+E)
    public boolean isBipartite(int[][] graph) {
        int[] colorOf = new int[graph.length];  // -1, 0, 1 or blue, colourless and red.

        for (int node = 0; node < graph.length; node++) {
            if (colorOf[node]==0){
                colorOf[node]=-1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(node);

                while (!queue.isEmpty()){
                    int polledNode = queue.poll();
                    for (int connNode:graph[polledNode]) {
                        if (colorOf[connNode]==colorOf[polledNode]){
                            return false;
                        }
                        else if (colorOf[connNode]==0){
                            colorOf[connNode] = -colorOf[polledNode];
                            queue.add(connNode);
                        }
                    }
                }
            }

        }

        return true;
    }

}

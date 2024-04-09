package solutions.medium.again;

public class IsGraphBipartiteDFS {

    // TC: O(V+E)
    public boolean isBipartite(int[][] graph) {
        int[] colorOf = new int[graph.length];  // -1, 0, 1 or blue, colourless and red.

        for (int node = 0; node < graph.length; node++) {
            if (colorOf[node]==0 && !dfsNode(graph, colorOf, 1, node)){
                return false;
            }
        }

        return true;
    }

    private boolean dfsNode(int[][] graph, int[] colorOf, int myColor, int node) {
        if (colorOf[node]!=0){
            return colorOf[node] == myColor;
        }

        colorOf[node] = myColor;
        for (int n:graph[node]) {
            if (!dfsNode(graph, colorOf, -myColor, n)){  // colouring connected node in other colour
                return false;
            }
        }
        return true;
    }
}

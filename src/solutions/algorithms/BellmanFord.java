package solutions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        //Store the distance taken to reach a node
        int[] dist = new int[V];
        Arrays.fill(dist, (int)(1e8));
        //Source will be always 0 , others will be +infinity
        dist[S]=0;
        //Relax all the edge number of nodes - 1 times
        //O(V * E)
        for(int i=0; i<V-1; i++){
            //relax edges for each iteration
            for(ArrayList<Integer> edge : edges){
                int node = edge.get(0);
                int adjNode = edge.get(1);
                int wt = edge.get(2);
                //if the distance is +infinity then no need to update distance
                if(dist[node]!=(1e8) && dist[node]+wt < dist[adjNode]){
                    dist[adjNode] = dist[node]+wt;
                }
            }
        }
        //if the graph don't contain any negative cycle, then we can't update distance Nth time
        for(ArrayList<Integer> edge : edges){
            int node = edge.get(0);
            int adjNode = edge.get(1);
            int wt = edge.get(2);
            //if the below condition pass, it means there is a cycle - becausing travelling in a negative cycle will keep on decreasing the distance😥
            if(dist[node]!=(1e8) && dist[node]+wt < dist[adjNode]){
                int[] temp = {-1};
                return temp;
            }
        }
        return dist;
    }
}

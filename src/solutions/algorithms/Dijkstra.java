package solutions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    // https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
//    V = 3, E = 3
//    adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}

    //Function to find the shortest distance of all the vertices
    //from the source vertex s.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int sourceVertex) {
        // Create a priority queue for storing the nodes as a pair {dist, node
        // where dist is the distance from source to the node.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[v];

        // Initialising distTo list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source initialised with dist=0.
        dist[sourceVertex] = 0;
        pq.add(new Pair( sourceVertex, 0));

        // Now, pop the minimum distance node first from the min-heap and traverse for all its adjacent nodes.
        while(pq.size() != 0) {
            int node = pq.peek().node;
            int dis = pq.peek().distance;

            pq.remove();

            ArrayList<ArrayList<Integer>> neighbours = adj.get(node);
            for (ArrayList<Integer> list:neighbours) {
                int adjNode = list.get(0);
                int weightToEdge = list.get(1);

                if(dis + weightToEdge < dist[adjNode]) {
                    dist[adjNode] = dis + weightToEdge;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }

            }
        }
        // Return the list containing shortest distances from source to all the nodes.
        return dist;
    }

    static class Pair{
        int node;
        int distance;
        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
}
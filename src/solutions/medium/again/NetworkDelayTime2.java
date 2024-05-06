package solutions.medium.again;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime2 {

    // Better than the previous solution
    // I refactored this solution based off 8ms solution
    // TC: O(E + Elog(E))
    // SC: O(V+E)
    // https://leetcode.com/problems/network-delay-time/solutions/3057628/java-100-dijkstra-bellman-ford-spfa-floyd-warshall/
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] adj = new ArrayList[n+1];
        int[] dist =new int[n+1];

        for(int i=0; i<=n; i++) {
            adj[i]=new ArrayList<>();
            dist[i]=Integer.MAX_VALUE;
        }
        dist[k]=0;

        for (int[] time : times) {
            adj[time[0]].add(new Pair(time[1], time[2]));
        }

        PriorityQueue<Pair> minPQ = new PriorityQueue<>((x, y)->x.time-y.time);
        minPQ.add(new Pair(k,0));

        int ans = Integer.MIN_VALUE;

        while(!minPQ.isEmpty()) {
            Pair p = minPQ.remove();
            int polledNode = p.node;
            int polledTime = p.time;

            //ans=Math.max(ans,time);
            for(Pair neighbour : adj[polledNode]) {
                int totalTime = polledTime + neighbour.time;
                if(totalTime < dist[neighbour.node]) {
                    dist[neighbour.node] = totalTime;
                    minPQ.add(new Pair(neighbour.node, totalTime));
                }
            }
        }

        for(int i=1 ;i<=n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }

    private record Pair(int node, int time){}
}

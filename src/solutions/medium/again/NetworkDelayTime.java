package solutions.medium.again;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime {

    // https://leetcode.com/problems/network-delay-time/solutions/109968/simple-java-djikstra-s-priorityqueue-optimized-solution-with-explanation/comments/226023

    public int networkDelayTime(int[][] times, int n, int k) {
        int maxTime = 0;
        ArrayList<ArrayList<NodeTime>> adjList = new ArrayList<>(n+1);

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] time:times) {
            adjList.get(time[0]).add(new NodeTime(time[1], time[2]));
        }

        PriorityQueue<NodeTime> minPQ = new PriorityQueue<>((x,y)->x.timeTaken-y.timeTaken);
        minPQ.add(new NodeTime(k, 0));

        Set<Integer> setOfVisited = new HashSet<>();

        while (!minPQ.isEmpty()){
            NodeTime polledNT = minPQ.poll();
            int polledNode = polledNT.toNode;
            int polledTime = polledNT.timeTaken;

            if (setOfVisited.contains(polledNode)) {
                continue;
            }
            else {
                setOfVisited.add(polledNode);
            }

            maxTime = polledTime;

            ArrayList<NodeTime> neighbourNodes = adjList.get(polledNode);
            for (NodeTime neighbourNT : neighbourNodes) {
                int neighbourNode = neighbourNT.toNode;
                int timeToNode = neighbourNT.timeTaken;

                if (!setOfVisited.contains(neighbourNode)){
                    minPQ.add(new NodeTime(neighbourNode, polledTime+timeToNode));
                }
            }
        }

        return setOfVisited.size() == n ? maxTime : -1;
    }

    private static class NodeTime{
        private int toNode;
        private int timeTaken;

        public NodeTime(int toNode, int timeTaken){
            this.toNode = toNode;
            this.timeTaken = timeTaken;
        }
    }
}

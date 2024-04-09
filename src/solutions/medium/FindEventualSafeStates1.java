package solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates1 {
    // https://leetcode.com/problems/find-eventual-safe-states/
    // My own slow 12ms solution
    public static void main(String[] args) {
        FindEventualSafeStates1 findEventualSafeStates = new FindEventualSafeStates1();
        int[][] arr1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(findEventualSafeStates.eventualSafeNodes(arr1));

        int[][] arr2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(findEventualSafeStates.eventualSafeNodes(arr2));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int graphSize = graph.length;
        List<Integer>[] adjList = new ArrayList[graphSize];
        for (int i = 0; i < graphSize; i++) {
            adjList[i] = new ArrayList<Integer>(graph[i].length);
        }

        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList[i].add(graph[i][j]);
            }
        }

//        for (int i = 0; i < adjList.length; i++) {
//            System.out.println(i+"-->"+adjList[i]);
//        }

        int[] visited = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            dfsFoundCycle(i, adjList, visited);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]==2) result.add(i);
        }

        return result;
    }

    public boolean dfsFoundCycle(int index, List<Integer>[] adj, int[] visitedArr){
        if (visitedArr[index]==1)return true;
        if (visitedArr[index]==2) return false;

        visitedArr[index] = 1;
        for (int aNode: adj[index]){
            if (dfsFoundCycle(aNode, adj, visitedArr)){
                return true;
            }
        }

        visitedArr[index] = 2;

        return false;
    }
}

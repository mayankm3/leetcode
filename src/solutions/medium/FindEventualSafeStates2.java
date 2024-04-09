package solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates2 {
    // https://leetcode.com/problems/find-eventual-safe-states/
    // I ended up optimizing only after seeing below solutions
    // https://leetcode.com/problems/find-eventual-safe-states/solutions/119871/straightforward-java-solution-easy-to-understand/
    // https://leetcode.com/problems/find-eventual-safe-states/solutions/605252/java-dfs-solution/
    // https://www.youtube.com/watch?v=Re_v0j0CRsg
    // Time Complexity: O(V + E)
    // SC: O(V)
    public static void main(String[] args) {
        FindEventualSafeStates2 findEventualSafeStates = new FindEventualSafeStates2();
        int[][] arr1 = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(findEventualSafeStates.eventualSafeNodes(arr1));

        int[][] arr2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(findEventualSafeStates.eventualSafeNodes(arr2));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int graphSize = graph.length;
        List<Integer> safeNodes = new ArrayList(graphSize);

        /* To see graph
        List<Integer>[] adjList = new ArrayList[graphSize];
        for (int i = 0; i < graphSize; i++) {
            adjList[i] = new ArrayList<Integer>(graph[i].length);
        }

        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList[i].add(graph[i][j]);
            }
        }

        for (int i = 0; i < adjList.length; i++) {
            System.out.println(i+"-->"+adjList[i]);
        }
         */

        int[] visited = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            if (!dfsFoundCycle(i, graph, visited)){
                safeNodes.add(i);   // add to list of safeNodes only if dfs was unable to find a cycle
            }
        }

        return safeNodes;
    }

    public boolean dfsFoundCycle(int index, int[][] sentGraph, int[] visitedArr){
        if (visitedArr[index]==1) return true;  // cycle detected thus return true
        if (visitedArr[index]==2) return false;

        visitedArr[index] = 1;
        for (int aNode: sentGraph[index]){
            if (dfsFoundCycle(aNode, sentGraph, visitedArr)){
                return true;
            }
        }

        visitedArr[index] = 2;

        return false;   // No cycle found
    }
}

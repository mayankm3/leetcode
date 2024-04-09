package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

    // https://leetcode.com/problems/course-schedule-ii/
    // https://leetcode.com/problems/course-schedule-ii/solutions/59342/java-dfs-double-cache-visiting-each-vertex-once-433ms/
    // TC: https://youtu.be/Akt3glAwyfY?t=532
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] coursesPair: prerequisites) {
            int course = coursesPair[0], prerequisite = coursesPair[1];
            adjacencyList[course].add(prerequisite);
        }

        List<Integer> schedulingOrder = new ArrayList<>(numCourses);

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(dfsFoundCycle(i, visited, adjacencyList, schedulingOrder)) return new int[0];
        }

//        int[] result = new int[numCourses];
//        for (int i = 0; i < schedulingOrder.size(); i++) {
//            result[i] = schedulingOrder.get(i);
//        }
//        return result;

        return schedulingOrder.stream().mapToInt(Integer::intValue).toArray();

    }

    public boolean dfsFoundCycle(int course, int[] visitedArr, List<Integer>[] adj, List<Integer> listOfIntegers){
        if (visitedArr[course]==1) return true;
        if (visitedArr[course]==2) return false;

        visitedArr[course]=1;
        for (int n: adj[course]) {
            if (dfsFoundCycle(n, visitedArr, adj, listOfIntegers)) return true;
        }

        listOfIntegers.add(course);
        visitedArr[course] = 2;

        return false;
    }
}

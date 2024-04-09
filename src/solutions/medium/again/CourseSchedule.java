package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    // https://leetcode.com/problems/course-schedule
    // https://www.youtube.com/watch?v=EgI5nU9etnU
    // This solution is modified by me but based on
    // https://leetcode.com/problems/course-schedule/solutions/1124408/clearly-explained-solution-1ms-java-dfs/
    // TC: O(N+P), where N is no. of courses and P is no. of prerequisites
    // SC:

    // Learning: if executes only when true
    public static void main(String[] args) {
        CourseSchedule courseSchedule  = new CourseSchedule();

        int[][] arr1 = {{0,1},{0,2},{1,3},{1,4},{3,4}};
        System.out.println(courseSchedule.canFinish(5, arr1));

//        int[][] arr2 = {{0,1},{1,2},{2,0}};
//        System.out.println(courseSchedule.canFinish(3, arr2));

//        int[][] arr3 = {{0,1},{1,2},{2,3},{3,1}};
//        System.out.println(courseSchedule.canFinish(4, arr3));

        if (!false) System.out.println("Hi");
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create Array of lists -> adjacency list
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] coursesPair : prerequisites) {
            int course = coursesPair[0], prerequisite = coursesPair[1];
            adj[course].add(prerequisite);
        }

//        for (List<Integer> a:adj) {
//            System.out.println(a);
//        }

        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's
        int[] visited = new int[numCourses];

        // Do DFS for each of the array courses to check a cycle
        for(int i=0; i<numCourses; i++) {
            if(dfsFoundCycle(i, visited, adj)) return false;
        }

        return true;
    }

    public boolean dfsFoundCycle(int course, int[] visited, List<Integer>[] adj) {
        // Return true if the course is visited and viewed again before completion, cycle is detected here
        if(visited[course] == 1) return true;

        if(visited[course] == 2) return false; // Return false if the course is completed processing

        visited[course] = 1;  // Mark the course as visited

        // DFS of all the other prerequisites current "course" is connected to
        for(int n : adj[course]) {
            if(dfsFoundCycle(n, visited, adj)) return true;
        }

        visited[course] = 2;  // If no more other prerequisites for the current "course" mark as completed and return false

        return false;
    }
}

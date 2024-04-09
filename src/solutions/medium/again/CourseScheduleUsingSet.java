package solutions.medium.again;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleUsingSet {
    // https://leetcode.com/problems/course-schedule
    // This solution is based on https://www.youtube.com/watch?v=EgI5nU9etnU
    // TC: O(N+P), where N is no. of courses and P is no. of prerequisites
    // SC:

    public static void main(String[] args) {
        CourseScheduleUsingSet courseSchedule  = new CourseScheduleUsingSet();

        int[][] arr1 = {{0,1},{0,2},{1,3},{1,4},{3,4}};
        System.out.println(courseSchedule.canFinish(5, arr1));

//        int[][] arr2 = {{0,1},{1,2},{2,0}};
//        System.out.println(courseSchedule.canFinish(3, arr2));
//
//        int[][] arr3 = {{0,1},{1,2},{2,3},{3,1}};
//        System.out.println(courseSchedule.canFinish(4, arr3));
//
//        int[][] arr4 = {{0,1},{1,0}};
//        System.out.println(courseSchedule.canFinish(2, arr4));

        // If executes only when true
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
        Set<Integer> integerSet = new HashSet<>(numCourses);

        // Do DFS for each of the array nodes to check a cycle
        for(int i=0; i<numCourses; i++) {
            if(dfsFoundCycle(i, integerSet, adj)) return false;
        }

        return true;
    }

    public boolean dfsFoundCycle(int course, Set<Integer> visited, List<Integer>[] adj) {
        if(visited.contains(course)) return true;   // Return true if the course was visited before, loop is detected here
        if (adj[course].isEmpty()) return false; // Since course has no prerequisites i.e., no cycle thus it can definitely be completed

        visited.add(course);

        // DFS of all the other courses current "course" is connected to
        for(int n : adj[course]) {
            if(dfsFoundCycle(n, visited, adj)) return true;
        }

        visited.remove(course);
        adj[course].clear();    // We won't have to run dfs again on its neighbours later on

        return false;
    }
}

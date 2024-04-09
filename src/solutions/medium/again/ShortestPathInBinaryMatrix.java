package solutions.medium.again;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    // https://leetcode.com/problems/shortest-path-in-binary-matrix/
    // https://leetcode.com/problems/shortest-path-in-binary-matrix/solutions/312706/java-bfs/
    // So we are moving one step at a time.
    // If there are no weights on edges you can use regular BFS otherwise Dijkstra's

    // Observe reply to below solution, I was doing that way initially but unsure about A* heuristics
    // https://leetcode.com/problems/shortest-path-in-binary-matrix/solutions/313347/a-search-in-python/
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

        int gridLength = grid.length;
        if (grid[0][0] == 1 || grid[gridLength-1][gridLength-1] == 1) return -1;

        boolean[][] visited = new boolean[gridLength][gridLength];
        visited[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int countSquares = 0;

        while (!queue.isEmpty()){
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int[] curPos  = queue.remove();
                int currXCord = curPos[0];
                int currYCord = curPos[1];

                if (currXCord==gridLength-1 && currYCord==gridLength-1) return countSquares+1;

                for (int[] dir:dirs) {
                    int nextXCord = dir[0]+currXCord;
                    int nextYCord = dir[1]+currYCord;

                    if (nextXCord>=0 && nextXCord<gridLength && nextYCord>=0 && nextYCord<gridLength
                            && visited[nextXCord][nextYCord]==false && grid[nextXCord][nextYCord]==0){
                        queue.add(new int[]{nextXCord, nextYCord});
                        visited[nextXCord][nextYCord] = true;
                    }
                }
            }
            countSquares++;
        }

        return -1;
    }

}

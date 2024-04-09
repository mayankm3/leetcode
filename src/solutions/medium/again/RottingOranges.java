package solutions.medium.again;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    // https://leetcode.com/problems/rotting-oranges/description
    // https://leetcode.com/problems/rotting-oranges/solutions/238681/java-clean-bfs-solution-with-comments/
    // https://www.youtube.com/watch?v=y704fEOx0s0 he showed why BFS works in less time
    // https://youtu.be/yf3oUhkvqA0?t=350
    // TC: O(m*n). O(m*n) for first two nested for loops. O(4*m*n) if all oranges except one rotten are fresh.
    // Space Complexity - O(m*n). Imagine if all oranges are rotten.

    public int orangesRotting(int[][] grid) {
        int minTakenToRott = 0, freshOranges = 0;

        int rows=grid.length, columns=grid[0].length;

        Queue<int[]> intArrQueue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]==2){
                    intArrQueue.offer(new int[]{i, j});
                } else if (grid[i][j]==1) {
                    freshOranges+=1;
                }
            }
        }

        // If there are already no fresh oranges at minute 0, the answer is just 0.
        if (freshOranges == 0) return minTakenToRott;

        int[][] fourDirections = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!intArrQueue.isEmpty() && freshOranges>0){

            int queueSize = intArrQueue.size(); // it fails if you put LHS in for loop directly

            for (int i = 0; i < queueSize; i++) {
                int[] gridPosition = intArrQueue.poll();

                for (int[] dirArr : fourDirections){
                    int xCord = gridPosition[0] + dirArr[0];
                    int yCord = gridPosition[1] + dirArr[1];

                    if (xCord<0 || yCord<0 || xCord>=rows || yCord>=columns || grid[xCord][yCord]!=1){
                        continue;
                    }

                    grid[xCord][yCord]=2;   // mark as rotten
                    intArrQueue.offer(new int[]{xCord, yCord}); // Put the coordinates of newly rotten orange in queue
                    freshOranges--;
                }
            }

            minTakenToRott++;
        }

        return freshOranges==0 ? minTakenToRott:-1;
    }
}

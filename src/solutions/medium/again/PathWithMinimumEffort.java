package solutions.medium.again;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    // https://leetcode.com/problems/path-with-minimum-effort/description/
    // https://www.youtube.com/watch?v=0ytpZyiZFhA
    // Time: O(ElogV) = O(M*N*4*log(M*N))
    // Space: O(M*N)
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        int[][] distances = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[0][0] = 0;

        PriorityQueue<Node> minPQ = new PriorityQueue<>((x,y)->x.difference-y.difference);
        minPQ.add(new Node(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while (!minPQ.isEmpty()){
            Node node = minPQ.remove();
            int diff = node.difference;
            int row = node.row;
            int column = node.column;

            if (row==rows-1 && column==columns-1) return diff;

            for (int i = 0; i < 4; i++) {
                int newR = row+dr[i];
                int newC = column+dc[i];

                if (newR>=0 && newR<rows && newC>=0 && newC<columns){
                    int absDiff = Math.abs(heights[newR][newC]-heights[row][column]);
                    int routeMaxEffort = Math.max(absDiff, diff);

                    if (routeMaxEffort<distances[newR][newC]){
                        distances[newR][newC] = routeMaxEffort;
                        minPQ.add(new Node(routeMaxEffort, newR, newC));
                    }
                }
            }

        }

        return 0;
    }

    private static class Node {
        int difference;
        int row;
        int column;

        public Node(int difference, int node, int distance){
            this.difference = difference;
            this.row = node;
            this.column = distance;
        }
    }
}

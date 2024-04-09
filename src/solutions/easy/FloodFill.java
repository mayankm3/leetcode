package solutions.easy;

public class FloodFill {

    // https://leetcode.com/problems/flood-fill/description/
    // My own solution. BTW, I had solved number of islands before

    // https://www.youtube.com/watch?v=C-2_uSRli8o
    // Time: O(M * N), where M <= 50 is number of rows, N <= 50 is number of columns in the matrix.
    // Space: O(M * N), it's the depth stack memory, in worst case is O(M * N)
    // https://stackoverflow.com/questions/50901203/dfs-and-bfs-time-and-space-complexities-of-number-of-islands-on-leetcode/50912382#50912382
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int extractedColour = image[sr][sc];

        dfsFlood(image, sr, sc, color, extractedColour);

        return image;
    }

    private void dfsFlood(int[][] twoDimArr, int row, int col, int colourWith, int prevColour){
        if(row<0 || col<0 || row>=twoDimArr.length || col>=twoDimArr[0].length || twoDimArr[row][col]==colourWith){
            return;
        } else if (twoDimArr[row][col]==prevColour) {
            twoDimArr[row][col] = colourWith;

            dfsFlood(twoDimArr, row-1, col, colourWith, prevColour);
            dfsFlood(twoDimArr, row+1, col, colourWith, prevColour);
            dfsFlood(twoDimArr, row, col-1, colourWith, prevColour);
            dfsFlood(twoDimArr, row, col+1, colourWith,prevColour);
        }
    }
}

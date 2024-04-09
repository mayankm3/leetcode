package solutions.medium.again;

public class NumberofIslands {

    // https://leetcode.com/problems/number-of-islands/description
    // https://leetcode.com/problems/number-of-islands/solutions/2497954/java-easy-solution-98-faster-code/
    public int numIslands(char[][] grid) {
        int gridRows = grid.length;
        int gridColumns = grid[0].length;
        int islands = 0;

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridColumns; j++) {
                if (grid[i][j]=='0'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] twoDCharArr, int r, int c){
        if (r<0 || c<0 || r>=twoDCharArr.length || c>=twoDCharArr[0].length || twoDCharArr[r][c]=='0')
            return;

        twoDCharArr[r][c]='0';

        dfs(twoDCharArr, r-1, c);
        dfs(twoDCharArr, r+1, c);
        dfs(twoDCharArr, r, c-1);
        dfs(twoDCharArr, r, c+1);

    }
}

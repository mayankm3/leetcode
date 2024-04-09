package solutions.medium.again;

public class NumberofProvinces {

    // https://leetcode.com/problems/number-of-provinces/description/
    // They have given an adjacency matrix
    // I correctly figured out that it's a DFS
    // https://www.youtube.com/watch?v=W3YyfjxKcA0 To understand problem
    // https://leetcode.com/problems/number-of-provinces/solutions/101338/neat-dfs-java-solution/
    // https://youtu.be/ACzkVtewUYA?t=710
    // SC: O(N) for marked array + O(N) for recursion stack space
    // TC: O(N)
    public int findCircleNum(int[][] isConnected) {
        int matrixLength = isConnected.length;

        boolean[] marked = new boolean[matrixLength];
        int provinces = 0;

        for (int i = 0; i < matrixLength; i++) {
            if (!marked[i]) {
                dfs(isConnected, marked, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] multiDimenArray, boolean[] visited, int i){
        for (int j = 0; j < multiDimenArray.length; j++) {
            if(multiDimenArray[i][j]==1 && !visited[j]){
                visited[j] = true;
                dfs(multiDimenArray, visited, j);

            }
        }
    }
}

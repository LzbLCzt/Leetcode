package dfs;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode200 {
    public static void main(String[] args) {
        leetcode200 leetcode200 = new leetcode200();
        System.out.println(leetcode200.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}}));
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    ans++;
                    dfs(isVisited, grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(boolean[][] isVisited, char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(isVisited, grid, i+1, j);
        dfs(isVisited, grid, i - 1, j);
        dfs(isVisited, grid, i, j+1);
        dfs(isVisited, grid, i, j-1);
    }
}

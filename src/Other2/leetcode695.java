package Other2;

public class leetcode695 {
    public static void main(String[] args) {

    }

    int res;
    static int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        res = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;

        grid[i][j] = 2;
        int sum = 0;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            sum += dfs(grid, newI, newJ);
        }
        return sum;
    }
}

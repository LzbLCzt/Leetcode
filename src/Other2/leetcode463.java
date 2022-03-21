package Other2;

import java.util.Arrays;

public class leetcode463 {
    public static void main(String[] args) {
        leetcode463 leetcode463 = new leetcode463();
        int res = leetcode463.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        System.out.println(res);
    }

    int res;
    public int islandPerimeter(int[][] grid) {
        res = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (1 == grid[i][j]) {
                    dfs(grid, i, j);
                    for (int k = 0; k < n; k++) {
                        System.out.println(Arrays.toString(grid[k]));
                    }
                    return res;
                }

            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            res++;
            return;
        }else if (grid[i][j] == 2) return;
        grid[i][j] = 2;
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] direction : directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];
            dfs(grid, newI, newJ);
        }
    }
}

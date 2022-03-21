package dfs2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode980 {
    public static void main(String[] args) {
        leetcode980 leetcode980 = new leetcode980();
        int res = leetcode980.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});
        System.out.println(res);
    }

    int res;
    boolean[][] isVisited;
    int numVisited;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        res = 0;
        numVisited = 0;
        isVisited = new boolean[n][m];
        for(int[] row: grid){
            for(int ele: row){
                numVisited += (ele == 0 || ele == 1)? 1: 0;
            }
        }
        backTrack(grid, 0, 0, 0);
        return res;
    }

    private void backTrack(int[][] grid, int i, int j, int visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || isVisited[i][j] || grid[i][j] == -1){
            return;
        }
        if (grid[i][j] == 2){
            if (visited == numVisited) res++;
            return;
        }

        visited++;
        isVisited[i][j] = true;
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] direction: directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];
            backTrack(grid, newI, newJ, visited);
        }
        visited--;
        isVisited[i][j] = false;
    }
}

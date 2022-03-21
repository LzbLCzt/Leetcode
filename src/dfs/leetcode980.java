package dfs;

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
    int startI;
    int startJ;
    boolean[][] isVisited;
    public int uniquePathsIII(int[][] grid) {
        //找到start位置
        int n = grid.length, m = grid[0].length;
        startI = 0;
        startJ = 0;
        int notUsed = 0; //统计无障碍格子数量
        res = 0;
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    startI = i;
                    startJ = j;
                    notUsed++;  //出发点也应该被当做一个无障碍格子
                }else if (grid[i][j] == 0){
                    notUsed++;
                }
            }
        }
        dfs(grid, startI, startJ,notUsed, 0);
        return res;
    }

    /*
    used:已经经过的无障碍格子数
    notUsed:共有多少个无障碍格子数
     */
    private void dfs(int[][] grid, int i, int j, int notUsed, int used) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == -1 || isVisited[i][j]){
            return;
        }
        if (grid[i][j] == 2){   //走到了终点了
            if (notUsed == used) {  //当所有无障碍格子都走过一遍
                res++;
            }
            return;
        }
        //走到这里说明，1.当前是无障碍格子，2.i、j不会越界 3.当前格子未被访问过

        //访问当前格子
        isVisited[i][j] = true;
        dfs(grid, i + 1, j, notUsed, used + 1);
        dfs(grid, i - 1, j, notUsed, used + 1);
        dfs(grid, i, j + 1, notUsed, used + 1);
        dfs(grid, i, j - 1, notUsed, used + 1);
        isVisited[i][j] = false;
    }
}

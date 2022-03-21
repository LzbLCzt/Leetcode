package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode63 {
    public static void main(String[] args) {
        leetcode63 leetcode63 = new leetcode63();
        int res = leetcode63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0) {
                    f[j] = f[j] + f[j - 1]; //此时右边的f[j]其实是二维dp中的dp[i-1][j], f[j-1]是二维dp中的f[i][j-1]
                }
            }
        }

        return f[m - 1];
    }
}

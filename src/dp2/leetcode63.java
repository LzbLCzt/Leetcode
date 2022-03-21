package dp2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode63 {
    public static void main(String[] args) {
        leetcode63 leetcode63 = new leetcode63();
//        int res = leetcode63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        int res = leetcode63.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}});
        System.out.println(res);
        int[] arr = new int[]{1,1,1};
        Arrays.fill(arr,0,2,100);
        System.out.println(Arrays.toString(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 1? 0: 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }
                if (j > 0){
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}

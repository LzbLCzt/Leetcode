package dp2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
//        int[][] dungeon = {{0, -3}};
        leetcode174 leetcode174 = new leetcode174();
        int ans = leetcode174.calculateMinimumHP(dungeon);
        System.out.println(ans);
    }


    //动态规划 + 逆向动态规划
    // *****dp[i][j] 表示从坐标 (i,j)到终点所需的最小初始值
    public int calculateMinimumHP(int[][] dungeon) {
      int n = dungeon.length, m = dungeon[0].length;
      int[][] dp = new int[n + 1][m + 1];
      Arrays.fill(dp[n], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[i][m] = Integer.MAX_VALUE;
        }
        dp[n][m-1] = dp[n-1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}

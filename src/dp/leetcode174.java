package dp;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        leetcode174 leetcode174 = new leetcode174();
        int ans = leetcode174.calculateMinimumHP(dungeon);
        System.out.println(ans);
    }

//    public int calculateMinimumHP(int[][] dungeon) {
//        int n = dungeon.length;
//        int m = dungeon[0].length;
//        int ans = dungeon[0][0];
//
//        int[][] dp = new int[n][m];
//        dp[0][0] = dungeon[0][0];
//        int[][] flag = new int[n][m];
//
//        for (int i = 1; i < m; i++) {
//            dp[0][i] = dp[0][i-1] + dungeon[0][i-1];
//        }
//
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i-1][0] + dungeon[i-1][0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                dp[i][j] = Integer.min(dp[i][j-1] + dungeon[i][j-1], dp[i-1][j] + dungeon[i-1][j]);
//                flag[i][j] = dp[i][j-1] + dungeon[i][j-1] < dp[i-1][j] + dungeon[i-1][j]? 0:1;
//            }
//        }
//
//        int i = 0, j = 0;
//        while (i < n && j < m){
//            if (flag[i][j+1] == 0){
//
//            }
//        }
//
//        return ans >= 0? 0: -ans;
//    }

    //动态规划 + 逆向动态规划
    // *****dp[i][j] 表示从坐标 (i,j)到终点所需的最小初始值
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[n-1][m] = 1;
        dp[n][m-1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minStartVal = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(minStartVal - dungeon[i][j],1);
            }
        }

        return dp[0][0];
    }
}

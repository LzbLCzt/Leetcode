package dp2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode64 {
    public static void main(String[] args) {
        leecode64 leecode64 = new leecode64();
        int res = leecode64.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
       int n = grid.length, m = grid[0].length;
       int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) dp[j] += grid[i][j];
                else dp[j] = Math.min(dp[j],dp[j-1]) + grid[i][j];
            }
        }
        return dp[m-1];
    }
}

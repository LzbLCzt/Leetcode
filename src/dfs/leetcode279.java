package dfs;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode279 {
    public static void main(String[] args) {
        
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //枚举j选择符合的j,即相当于对比dp[1], dp[2],dp[3]....选择最小dp[j]
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = 1 + min;
        }

        return dp[n];
    }
}

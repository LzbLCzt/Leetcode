package dp;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode221 {
    public static void main(String[] args) {
        
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1'? 1: 0;
            ans = Math.max(ans, dp[i][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1'? 1: 0;
            ans = Math.max(ans, dp[0][i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}

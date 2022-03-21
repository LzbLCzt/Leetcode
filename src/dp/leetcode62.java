package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode62 {
    public static void main(String[] args) {
        leetcode62 leetcode62 = new leetcode62();
        System.out.println(leetcode62.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];
        for(int i = 1; i < n; i++) dp[0][i] = 1;
        for(int i = 1; i < m; i++) dp[i][0] = 1;

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

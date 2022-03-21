package dp2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode221 {
    public static void main(String[] args) {
        char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        leetcode221 leetcode221 = new leetcode221();
        int res = leetcode221.maximalSquare(chars);
        System.out.println(res);
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i] == '0'? 0: 1;
            res = Math.max(res, dp[0][i]);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] == '0'? 0: 1;
            res = Math.max(res, dp[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
            res = Math.max(res, Arrays.stream(dp[i]).max().getAsInt());
        }
        return res * res;
    }
}


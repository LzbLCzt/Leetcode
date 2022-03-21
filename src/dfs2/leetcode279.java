package dfs2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode279 {
    public static void main(String[] args) {
        leetcode279 leetcode279 = new leetcode279();
        int ans = leetcode279.numSquares(12);
        System.out.println(ans);
    }

    public int numSquares(int n) {
        if (n < 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n);
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }


}

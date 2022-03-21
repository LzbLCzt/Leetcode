package dp2;

import java.util.Arrays;

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
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n-1];
    }

}

package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode516 {
    public static void main(String[] args) {
        leecode516 leecode516 = new leecode516();
        int ans = leecode516.longestPalindromeSubseq("cbbd");
        System.out.println(ans);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode516 {
    public static void main(String[] args) {
        leecode516 leecode516 = new leecode516();
        int ans = leecode516.longestPalindromeSubseq("bbbab");
        System.out.println(ans);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (charArray[i] == charArray[j]){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

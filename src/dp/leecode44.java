package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode44 {
    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        //状态初始化--第一列
        for(int i = 1; i <= n; i++){
            dp[i][0] = false;
        }

        //初始化第一行
        for(int i = 1; i <= m; i++){
            //只有左边是true并且是*的情况下才是true，其他情况都是false；
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }

        //状态转移
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }
}

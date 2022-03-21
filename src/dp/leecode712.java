package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode712 {
    public static void main(String[] args) {
        leecode712 leecode712 = new leecode712();
        int res = leecode712.minimumDeleteSum("sea", "eat");
        System.out.println(res);
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        //dp初始化
            //dp[n]表示此时s1 = "", dp[m]表示此时s2 = ""
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.codePointAt(i);
        }
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.codePointAt(j);
        }
        //状态转移，i、j逆序遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i), dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }
        return dp[0][0];
    }
}

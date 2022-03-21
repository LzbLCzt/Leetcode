package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode712 {
    public static void main(String[] args) {
        leecode712 leecode712 = new leecode712();
//        int res = leecode712.minimumDeleteSum("sea", "eat");
        int res = leecode712.minimumDeleteSum("delete", "lete");
        System.out.println(res);
    }

    //dp[i][j]表示s1在[i,n]的子串和s2在[j,m]的子串所需删除的字符的最小Ascii值
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dp[i-1][0] + s1.codePointAt(i-1);
        }
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = dp[0][j-1] + s2.codePointAt(j-1);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j] + s1.codePointAt(i-1), dp[i][j-1] + s2.codePointAt(j-1));
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}

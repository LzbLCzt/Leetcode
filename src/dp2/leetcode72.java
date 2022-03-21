package dp2;


/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode72 {
    public static void main(String[] args) {
        leetcode72 leetcode72 = new leetcode72();
//        int ans = leetcode72.minDistance("horse", "ros");
        int ans = leetcode72.minDistance("intention", "execution");
        System.out.println(ans);
    }

    //时间复杂度 ：O(mn)，其中 mm 为 word1 的长度，nn 为 word2 的长度。
    //空间复杂度 ：O(mn)，我们需要大小为 O(mn)O(mn) 的 DD 数组来记录状态值。
    public int minDistance(String word1, String word2) {
      int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[n][m];
    }
}

package dp2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode32 {
    public static void main(String[] args) {
        leetcode32 leetcode32 = new leetcode32();
        int ans = leetcode32.longestValidParentheses("()(())");
        System.out.println(ans);
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if ('(' == chars[i]){
                continue;
            }
            if ('(' == chars[i - 1]){
                dp[i] = i - 2 >= 0? dp[i - 2] + 2: 2;
            }else if (i - dp[i - 1] - 1 >= 0 && '(' == chars[i - dp[i-1] - 1]){
                dp[i] = i - dp[i-1] - 2 >= 0? dp[i - dp[i-1] - 2] + dp[i-1] + 2: dp[i-1] + 2;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

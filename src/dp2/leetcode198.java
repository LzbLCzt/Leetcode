package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode198 {
    public static void main(String[] args) {
        leetcode198 leetcode198 = new leetcode198();
        int ans = leetcode198.rob(new int[]{1, 2, 3, 1});
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (i == 1){
                dp[1] = Math.max(dp[0], nums[1]);
            }else {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

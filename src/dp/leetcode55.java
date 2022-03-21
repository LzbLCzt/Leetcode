package dp;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        if (dp[0] == 0) return false;
        for (int i = 1; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] <= 0){
                return false;
            }
        }

        return true;
    }
}

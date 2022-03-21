package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode53 {
    public static void main(String[] args) {
        leetcode53 leetcode53 = new leetcode53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(leetcode53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] > 0? dp[i-1] + nums[i]: nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

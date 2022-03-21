package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode416 {
    public static void main(String[] args) {


    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2){
            return false;
        }
        int max = 0, sum = 0;
        for (int x : nums) {
            max = Math.max(max, x);
            sum += x;
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        if (max > target){
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (num > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n-1][target];
    }
}

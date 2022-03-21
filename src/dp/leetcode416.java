package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode416 {
    public static void main(String[] args) {


    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;    //maxNum指nums中数值最大的元素
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        //******
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        //边界条件1
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        //*****边界条件2
        dp[0][nums[0]] = true;


        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}

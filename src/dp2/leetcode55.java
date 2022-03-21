package dp2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode55 {
    public static void main(String[] args) {
        leetcode55 leetcode55 = new leetcode55();
        boolean ans = leetcode55.canJump(new int[]{3,2,1,0,4});
        System.out.println(ans);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n - 1; i++) {
            dp[i] = i > 0? Math.max(dp[i-1] - 1, nums[i]): nums[i];
            if (dp[i] == 0){
                return false;
            }
        }
        return true;
    }
}

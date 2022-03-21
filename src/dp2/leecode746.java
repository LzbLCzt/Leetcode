package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode746 {
    public static void main(String[] args) {
        leecode746 leecode746 = new leecode746();
        int res = leecode746.minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(res);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i - 2]);
        }
        return dp[n];
    }
}

package dp;

/**
 * @author shkstart
 * @create 2021-04-04 13:43
 */
public class leetcode42_dp {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int max = height[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            maxLeft[i] = max;
        }

        max = height[n-1];
        for (int j = n - 1; j >= 0; j--) {
            max = Math.max(max, height[j]);
            maxRight[j] = max;
        }

        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int high = Math.min(maxLeft[i], maxRight[i]);
            if(height[i] < high){
                dp[i] = high - height[i];
                ans += dp[i];
            }
        }

        return ans;
    }
}

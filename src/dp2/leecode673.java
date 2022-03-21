package dp2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode673 {
    public static void main(String[] args) {
        leecode673 leecode673 = new leecode673();
        int res = leecode673.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(res);
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int maxLen = 1;
        int res = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if (dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen){
                maxLen = dp[i];
                res = cnt[i];
            }else if (dp[i] == maxLen){
                res += cnt[i];
            }
        }
        return res;
    }
}

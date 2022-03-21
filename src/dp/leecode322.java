package dp;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leecode322 {
    public static void main(String[] args) {
        leecode322 leecode322 = new leecode322();
        int[] arr = {1,2,5};
        System.out.println(leecode322.coinChange(arr,11));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);

        dp[0] = 0;
        for(int i = 1; i < max; i++){
            for (int coin : coins) {
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] > amount? -1: dp[amount];
    }
}

package Array2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode188 {
    public static void main(String[] args) {
        leetcode188 leetcode208 = new leetcode188();
        int[] prices = {3, 2, 6, 5, 0, 3};
        int res = leetcode208.maxProfit(2, prices);
        System.out.println(res);
    }

    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        k = Math.min(k, prices.length / 2);
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(sell[j-1] - prices[i], buy[j]);
                sell[j] = Math.max(buy[j] + prices[i], sell[j]);
            }
        }
        return sell[k - 1];
    }
}

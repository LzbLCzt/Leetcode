package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode122 {
    public static void main(String[] args) {
        leetcode122 leetcode122 = new leetcode122();
        int ans = leetcode122.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += (prices[i] - prices[i-1]) > 0? prices[i] - prices[i-1]: 0;
        }
        return profit;
    }
}

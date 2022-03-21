package dp2;

/**


 */
public class leetcode121 {
    public static void main(String[] args) {
        leetcode121 leetcode121 = new leetcode121();
        System.out.println(leetcode121.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

}

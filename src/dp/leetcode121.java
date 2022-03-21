package dp;

/**


 */
public class leetcode121 {
    public static void main(String[] args) {
        leetcode121 leetcode121 = new leetcode121();
        System.out.println(leetcode121.maxProfit(new int[]{7,6,4,3,1}));
    }
    //方法一：动态规划：
    //dp[i]：表示截止第i天能够获得的最大收益
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int n = prices.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int minPrice = prices[0];

        for(int i = 0; i < n; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                dp[i+1] = dp[i];
            }else if(prices[i] - minPrice > dp[i]){
                dp[i+1] = prices[i] - minPrice;
            }else dp[i+1] = dp[i];
        }

        return dp[n];
    }

    //方法二：
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}

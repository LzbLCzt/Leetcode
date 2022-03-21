package myCode;

/**


 */
public class leetcode121copy {
    public static void main(String[] args) {
        leetcode121copy leetcode121 = new leetcode121copy();
        System.out.println(leetcode121.maxProfit(new int[]{7,6,4,3,1}));
    }
    //方法一：动态规划：
    //dp[i]：表示截止第i天能够获得的最大收益
    public int maxProfit(int[] prices) {
       if(prices.length < 2) return 0;

       int n = prices.length;
       int[] dp = new int[n];
       int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(prices[i] - minPrice, dp[i-1]);
            minPrice = Math.min(prices[i], minPrice);
        }

        return dp[n-1];
    }

    //方法二：
    public int maxProfit2(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if(prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }

}

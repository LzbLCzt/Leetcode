package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode300 {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,4,10,5,6};
        leetcode300 leetcode300 = new leetcode300();
        int ans = leetcode300.lengthOfLIS(arr);
        System.out.println(ans);
    }

    //动态规划
    //时间复杂度：O(n^2)
    //空间复杂度：O(n)
//    int ans = 1;
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp= new int[n];   //dp[i]指0->i之间的最长子序列，*******并且最长子序列必须包括nums[i]
//        Arrays.fill(dp,1);
//
//        for(int i = 1; i < n; i++){
//            for(int j = 0; j < i; j++){
//                if(nums[i] > nums[j]){
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            ans = Math.max(ans, dp[i]);
//        }
//
//        return ans;
//    }

    //方法二：贪心 + 二分查找(难)=> 先背下来，再慢慢搞清楚
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j){
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}

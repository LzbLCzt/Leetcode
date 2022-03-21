package dp2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode300 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 9, 1, 2, 3, 4, 5};
//        int[] arr = {10,9,2,5,3,7,101,18};
        leetcode300 leetcode300 = new leetcode300();
        int ans = leetcode300.lengthOfLIS(arr);
        System.out.println(ans);
    }

    //动态规划
    //时间复杂度：O(n^2)
    //空间复杂度：O(n)
    //dp[i]表示以i作为序列结尾元素时，能够构成的递增子序列的最大长度
//    public int lengthOfLIS(int[] nums) {
//       int n = nums.length;
//       int[] tails = new int[n];
//       int res = 0;
//        for (int num : nums) {
//            int i = 0, j = res;
//            while (i < j){
//                int mid = (i + j) / 2;
//                if (num > tails[mid]) i = mid + 1;
//                else j = mid;
//            }
//            tails[i] = num;
//            if (j == res){
//                res++;
//            }
//        }
//        return res;
//    }

    //方法二：贪心 + 二分查找
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 0;
        int[] tails = new int[n];
        for (int k = 0; k < n; k++) {
            int i = 0, j = res;
            while (i < j){
                int mid = (i + j) / 2;
                if (nums[k] > tails[mid]) i = mid + 1;
                else j = mid;
            }
            tails[i] = nums[k];
            if (res == j) ++res;
        }
        return Arrays.stream(tails).max().getAsInt();
    }
}
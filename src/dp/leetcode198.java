package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode198 {
    public static void main(String[] args) {

    }

    //动态规划
//    public int rob(int[] nums){
//        if(nums == null || nums.length == 0) return 0;
//
//        int length = nums.length;
//        if(length == 1) return nums[0];
//
//        int[] dp = new int[length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for(int i = 2; i < length; i++){
//            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
//        }
//
//        return dp[length-1];
//    }

    //方法二：动态规划 + 滚动数据
//    public int rob2(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0];
//        }
//        int first = nums[0], second = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < length; i++) {
//            int temp = second;
//            second = Math.max(first + nums[i], second);
//            first = temp;
//        }
//        return second;
//    }
    //时间：O(n)
    //空间：O(1)


    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = a;
            a = b;
            b = Math.max(temp + nums[i], a);
        }

        return b;
    }
}

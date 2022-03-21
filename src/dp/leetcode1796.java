package dp;

/**
采用动态规划
dp[i] 表示第i个位置需要移动的最小操作数；
 时间、空间：O(n), O(n)
 */
public class leetcode1796 {
    public int[] minOperations(String boxes) {

        int[] dp = new int[boxes.length()];
        int total = 0;  //记录移动所有盒子到第i个位置所需要的次数
        int left = 0, right = 0;    //分别记录第i个位置左边为1的元素个数（包括第i个元素）， 右边为1的元素的个数；

        //计算第0个位置的left
        if(boxes.charAt(0) == '1') left++;

        //计算第0个位置的total、right
        for(int i = 1; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                total += i;
                right++;
            }
        }
        dp[0] = total;

        //动态规划处理剩下的位置
        for(int i = 1; i < boxes.length(); i++){
            total = dp[i-1] + left - right;    //***第i个位置相比于第i-1个位置；
            if(boxes.charAt(i) == '1'){
                left++;
                right--;
            }
            dp[i] = total;
        }

        return dp;
    }
}

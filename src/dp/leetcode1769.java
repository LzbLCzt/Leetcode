package dp;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode1769 {
    public static void main(String[] args) {

    }

    //动态规划
    //转移方程：dp[i] = dp[i-1] + left - right;
    public int[] minOperations(String boxes) {
        if(boxes.length() < 1) return null;

        int n = boxes.length();
        int[] answer = new int[n];
        //对于当前位置i来说左边和右边的1的个数
        int left = boxes.charAt(0) == '1'? 1: 0;
        int right = 0;
        //计算answer[0],right
        for (int i = 1; i < n; i++) {
            if(boxes.charAt(i) == '1'){
                answer[0] += i;
                right++;
            }
        }

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] + left - right;
            if(boxes.charAt(i) == '1'){
                left++;
                right--;
            }
        }
        return answer;
    }
}

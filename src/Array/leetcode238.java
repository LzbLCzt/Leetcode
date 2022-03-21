package Array;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode238 {
    public static void main(String[] args) {
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];

        answer[0] = 1;
        //构造前缀和数组
        for (int i = 1; i < len; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        //利用变量动态构造后缀和数组
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            //更新R
            R *= nums[i];
        }

        return answer;
    }
}

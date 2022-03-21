package Array;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode137 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }

            if (total % 3 != 0){
                ans |= (1 << i);    //将ans的第i个位置设置为1
            }
        }

        return ans;
    }

}

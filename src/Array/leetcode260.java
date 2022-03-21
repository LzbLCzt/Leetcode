package Array;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode260 {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        //找到ans的二进制为1的位置
        int div = 1;
        while ((div & ans) == 0){
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }

        return new int[]{a,b};
    }

}

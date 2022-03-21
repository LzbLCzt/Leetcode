package Array2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode137 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
       int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            if (count % 3 != 0){
                res |= count << i;
            }
        }
        return res;
    }
}

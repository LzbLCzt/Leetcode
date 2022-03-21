package Array2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode136 {
    public static void main(String[] args) {

    }

//    public int singleNumber(int[] nums) {
//
//    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}

package Array2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode260 {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
       int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int div = 0;
        while (((sum >> div) & 1) == 0){
            div++;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            int digit = (num >> div) & 1;
            if (digit == 1){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};

    }

}

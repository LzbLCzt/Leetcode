package Array;

import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode136 {
    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        List<String> list = Arrays.asList(array);
        String[] a = {};
        list.toArray(a);

        System.out.println(a);
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}

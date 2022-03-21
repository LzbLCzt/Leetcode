package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 *
 */
public class leetcode1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        leetcode1 leetcode1 = new leetcode1();
        System.out.println(Arrays.toString(leetcode1.twoSum(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            Integer temp = map.get(target - nums[i]);
            if(temp != null){
                ans[0] = i;
                ans[1] = temp;
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }


}

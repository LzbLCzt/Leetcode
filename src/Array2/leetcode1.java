package Array2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        leetcode1 leetcode1 = new leetcode1();
        System.out.println(Arrays.toString(leetcode1.twoSum(nums, 9)));
    }

    //时间、空间：O(n),O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])){
                res[1] = map.get(nums[i]);
                res[0] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }


}

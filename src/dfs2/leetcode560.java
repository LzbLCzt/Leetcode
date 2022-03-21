package dfs2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode560 {
    public static void main(String[] args) {
        leetcode560 leetcode560 = new leetcode560();
        int nas = leetcode560.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(nas);
    }

    public int subarraySum(int[] nums, int k) {
       int n = nums.length;
       int count = 0, preSum = 0;
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum,0) + 1);
        }
        return count;
    }
}

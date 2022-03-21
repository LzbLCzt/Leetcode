package dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode560 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map< Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);//****用于表示只有一个元素的数组也能形成一个符合条件的子数组
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}

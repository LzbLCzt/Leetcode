package Other2;

import java.util.HashMap;
import java.util.Map;

public class leetcode525 {
    public int findMaxLength(int[] nums) {
        int res = 0, curDiff = 0, n = nums.length;   //curDiff：当前前缀子数组1的数量与0的数量的差
        Map<Integer, Integer> map = new HashMap<>();    //key:curDiff， value：当前前缀子数组右侧下标
        map.put(0, -1);
        for (int r = 0; r < n; r++) {
            curDiff += nums[r] == 1? 1: -1;
            if (map.containsKey(curDiff)){  //***仔细思考这里的为什么是curDiff****
                int l = map.get(curDiff);
                res = Math.max(res, r - l);
            }else map.put(curDiff, r);
        }
        return res;
    }
}

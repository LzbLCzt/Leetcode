package Other2;

import java.util.HashMap;
import java.util.Map;

public class leetcode325 {
    public static void main(String[] args) {

    }

    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0, n = nums.length, curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();    //key:nums[i], value:i(记录当前前缀和右侧下标)   ****
        map.put(0, -1);
        for(int right = 0; right < n; right++){
            curSum += nums[right];
            Integer left = map.get(curSum - k);
            if (left != null) res = Math.max(res, right - left);
            //若curSum已经存在于map中，不要去更新其value*****
            if(!map.containsKey(curSum)) map.put(curSum, right);
        }
        return res;
    }
}

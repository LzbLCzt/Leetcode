package Graph.Union_Find;

import java.util.HashSet;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        leetcode128 leetcode128 = new leetcode128();
        System.out.println(leetcode128.longestConsecutive(nums));
    }

    /*
   思路：使用HashSet
        1. 将元素放入HashSet（为了去重+高效率查找）
        2. 对指定元素进行枚举，例如当前元素 = x， 去找是否存在x+1， x+2.....
            2.1 指定元素指的是：对于元素x，如果不存在x-1，才对x进行枚举，否则没有必要
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (Integer x : set) {
            if(!set.contains(x-1)){ //***指定元素
                int max = 1;
                while (set.contains(x+1)){
                    x++;
                    max++;
                }
                ans = Math.max(ans,max);
            }
        }

        return ans;
    }
}

package Array;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode15 {
    public static void main(String[] args) {
    }

    /*
    思路：双指针
        1. 枚举第一二个数字a，b，再利用while循环找到第三个数字
    时间：O(n^2)
    空间：O(logN)
     */
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3) return new ArrayList<>();
        ans = new ArrayList<>();

        //1. 排序
        Arrays.sort(nums);

        //2. 遍历nums，枚举第一个数字a
        for (int first = 0; first < n; first++) {
            //2.1 保证a不能重复
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }

            //第三个数字默认是nums的尾部元素
            int third = n - 1;
            int target = -nums[first];

            //3. 枚举第二个数b
            for (int second = first + 1; second < n; second++) {
                //3.1 保证b不重复
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                //3.2 确定a、b以后，寻找c
                //3.3 保证b的指针在c的指针左侧
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if(second == third) break;

                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

}

package myCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
题目：两数之和
 给定一个整数数组 nums?和一个整数目标值 target，请你在该数组中找出 和为目标值 的那?两个?整数，并返回它们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 你可以按任意顺序返回答案。
 算法解析：

 */
public class t1 {
    public static void main(String[] args) {
        t1 q1 = new t1();
        int[] arr = {1, 3, 4, 56, 4, 4, 67, 4, 3, 3, 56, 6, 3, 2, 5, 56, 3, 5, 6, 5, 7, 9, 6, 4, 23, 32};
        System.out.println(Arrays.toString(q1.twoSum(arr,60)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();    //key->具体值 value->对应的在nums的下标
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

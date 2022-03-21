package Stack;


import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode496 {
    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};

        int[] ans = new leetcode496().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));


    }

    /*
    方法二：单调栈
        1. 针对nums2：使用栈，找到其每个元素num2[i]及其对应右侧比它大的第一个元素num，放入一个hashmap中
        2. 对nums1的每个元素，从hashmap去获取value即可
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
       int n2 = nums2.length;
       Map<Integer, Integer> map = new HashMap<>();
       int[] ans = new int[n1];

       //维护hashmap
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peekFirst()){
                map.put(stack.pollFirst(), nums2[i]);
            }

            stack.offerFirst(nums2[i]);
        }

        //根据hashmap，计算题目要求
        for (int i = 0; i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i] ,-1);
        }

        return ans;
    }

    /*
    方法一：暴力
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int m = nums2.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int num = nums1[i];
            for (int j = 0; j < m; j++) {
                if(nums2[j] == num){
                    for (int k = j; k < m; k++) {
                        if(nums2[k] > num){
                            ans[i] = nums2[k];
                            break;
                        }
                        if(k == m - 1) ans[i] = -1;
                    }
                    break;
                }
            }
        }

        return ans;
    }
}

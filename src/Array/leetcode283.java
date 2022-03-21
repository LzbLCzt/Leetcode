package Array;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode283 {
    public static void main(String[] args) {
        leetcode283 leetcode283 = new leetcode283();
        int[] arr = {0, 1, 0, 3, 12};
        leetcode283.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    //方法一（自己）：单指针
    public void moveZeroes(int[] nums) {
        int t = 0;
        int i = 0;
        while (i < nums.length){
            if (nums[i] == 0){
                t++;
                i++;
                continue;
            }
            if (t != 0){
                nums[i-t] = nums[i];
                nums[i] = 0;
            }
            i++;
        }
    }

    //双指针
//    public void moveZeroes(int[] nums) {
//        int n = nums.length, left = 0, right = 0;
//        while (right < n) {
//            if (nums[right] != 0) {
//                swap(nums, left, right);
//                left++;
//            }
//            right++;
//        }
//    }
//
//    public void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }

}

package Other;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode31 {
    public static void main(String[] args) {
        leetcode31 leetcode31 = new leetcode31();
        int[] arr = {1,1};
        leetcode31.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;    //这里i的设置很重要*****
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0){    //如果i = -1，说明此时数组是类似：10, 9, 8, 7, 6, .....,1这种，其下一个排列会变成：1,2,3,4.....,10
            int j = nums.length - 1;
            while (nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }

        reverse(nums,i + 1);
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}

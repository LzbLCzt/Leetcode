package Other2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode31 {
    public static void main(String[] args) {
        leetcode31 leetcode31 = new leetcode31();
        int[] arr = {1, 1, 5};
        leetcode31.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        if (i >= 0){
            int j = n - 1;
            while (nums[j] <= nums[i]) --j;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int index) {
        int l = index, r = nums.length - 1;
        while (l < r){
            swap(nums, l ,r);
            ++l;
            --r;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

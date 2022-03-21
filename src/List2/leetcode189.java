package List2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode189 {
    public static void main(String[] args) {
        leetcode189 leetcode189 = new leetcode189();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        leetcode189.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

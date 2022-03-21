package Array2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode75 {
    public static void main(String[] args) {
        leetcode75 leetcode75 = new leetcode75();
//        int[] arr = new int[]{2,0,2,1,1,0};
        int[] arr = new int[]{1,2,0};
        leetcode75.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
      int n = nums.length;
      int l = 0, m = 0, r = n - 1;
      while (m <= r){
          int num = nums[m];
          if (num == 0){
              swap(nums, l, m);
              l++;
              m++;
          }else if (num == 1){
              m++;
          }else {
              swap(nums, m, r);
              r--;
          }
      }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}

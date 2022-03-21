package BinarySearch;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode34 {
    public static void main(String[] args) {
        leetcode34 leetcode34 = new leetcode34();
        int[] ans = leetcode34.searchRange(new int[]{8,8,8,8,8,8}, 8);
        System.out.println(Arrays.toString(ans));
    }

    int[] res;
    public int[] searchRange(int[] nums, int target) {
        res = new int[2];
        Arrays.fill(res, -1);
        binarySearch(nums, target, 0, nums.length - 1);
        return res;
    }
    private void binarySearch(int[] nums, int target, int low, int high){
        if (low > high) {
            return;
        }
        int mid = (low + high) / 2;
        int midVal = nums[mid];
        int lowVal = nums[low];
        int highVal = nums[high];

        if (target == midVal) {
            int r = mid, l = mid;
            while (r + 1 < nums.length && nums[r] == nums[r + 1]){
                r++;
            }
            while (l - 1 >= 0 && nums[l - 1] == nums[l]){
                l--;
            }
            res[0] = l;
            res[1] = r;
            return;
        } else if (target > midVal) {
            while (mid + 1 < nums.length && nums[mid] == nums[mid + 1]){
                mid++;
            }
            binarySearch(nums, target, mid + 1, high);
        }else {
            while (mid - 1 >= 0 && nums[mid - 1] == nums[mid]){
                mid--;
            }
            binarySearch(nums, target, low, mid - 1);
        }
    }
}

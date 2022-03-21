package BinarySearch2;

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

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

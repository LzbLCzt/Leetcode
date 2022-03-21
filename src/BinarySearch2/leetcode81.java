package BinarySearch2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode81 {
    public static void main(String[] args) {
        leetcode81 leetcode81 = new leetcode81();
        boolean ans = leetcode81.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},2);
        System.out.println(ans);
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums, 0, n - 1, target);
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        int midVal = nums[mid];
        if (target == nums[left] || target == nums[right] || target == midVal) return true;

        if (nums[left] == midVal){
            return binarySearch(nums, mid + 1, right - 1, target) || binarySearch(nums, left + 1, mid - 1, target);
        }
        else if(nums[left] < midVal){
            if (nums[left] < target && target < midVal) return binarySearch(nums, left, mid - 1, target);
            else return binarySearch(nums, mid + 1, right - 1, target);
        }else {
            if (target > midVal && target < nums[right]) {
                return binarySearch(nums, mid + 1, right - 1, target);
            }else {
                return binarySearch(nums, left + 1, mid - 1, target);
            }
        }
    }
}

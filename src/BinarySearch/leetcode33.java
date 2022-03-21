package BinarySearch;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode33 {
    public static void main(String[] args) {
        leetcode33 leetcode33 = new leetcode33();
        int ans = leetcode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n < 1) return -1;

        return searchHelper(nums,0,n-1,target);
    }

    private int searchHelper(int[] nums, int left, int right, int target) {
        if (right < left){
            return -1;
        }
        int mid = (left + right) / 2;
        int leftVal = nums[left];
        int rightVal = nums[right];
        int midVal = nums[mid];
        if (leftVal == target){
            return left;
        }
        if (midVal == target){
            return mid;
        }
        if (rightVal == target){
            return right;
        }

        if (leftVal < midVal){  //左侧有序*****
            if (target > leftVal && target < midVal){
                return searchHelper(nums, left + 1, mid - 1, target);
            }else {
                return searchHelper(nums, mid + 1, right - 1, target);
            }
        }else { //右侧有序*****
            if (target > midVal && target < rightVal){
                return searchHelper(nums, mid + 1, right - 1, target);
            }else {
                return searchHelper(nums, left + 1, mid - 1, target);
            }
        }
    }

}

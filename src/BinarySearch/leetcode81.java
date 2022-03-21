package BinarySearch;

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
        if (n < 1) return false;

        return searchHelper(nums,0,n-1,target);
    }

    private boolean searchHelper(int[] nums, int left, int right, int target) {
        if (right < left){
            return false;
        }
        int mid = (left + right) / 2;
        int leftVal = nums[left];
        int rightVal = nums[right];
        int midVal = nums[mid];
        if (leftVal == target){
            return true;
        }
        if (midVal == target){
            return true;
        }
        if (rightVal == target){
            return true;
        }

        if (leftVal == midVal){
            return searchHelper(nums, left + 1, mid - 1, target) || searchHelper(nums, mid + 1, right - 1, target);
        }else if (leftVal < midVal){  //左侧有序
            if (target > leftVal && target < midVal){
                return searchHelper(nums, left + 1, mid - 1, target);
            }else {
                return searchHelper(nums, mid + 1, right - 1, target);
            }
        }else { //右侧有序
            if (target > midVal && target < rightVal){
                return searchHelper(nums, mid + 1, right - 1, target);
            }else {
                return searchHelper(nums, left + 1, mid - 1, target);
            }
        }
    }

}

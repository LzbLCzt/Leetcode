package BinarySearch2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode33 {
    public static void main(String[] args) {
        leetcode33 leetcode33 = new leetcode33();
        int ans = leetcode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        return dfs(nums,0, nums.length - 1, target);
    }

    private int dfs(int[] nums,int l, int r, int target) {
        if (l > r){
            return -1;
        }
        int leftVal = nums[l];
        int rightVal = nums[r];
        int mid = (l + r)  / 2;
        int midVal = nums[mid];
        if (leftVal == target) return l;
        else if (rightVal == target) return r;
        else if (midVal == target) return mid;

        if (midVal > leftVal){
            if (target > leftVal && target < midVal){
                return dfs(nums, l + 1, mid - 1, target);
            }else {
                return dfs(nums, mid + 1, r - 1, target);
            }
        }else {
            if (target > midVal && target < rightVal){
                return dfs(nums, mid + 1, r - 1, target);
            }else {
                return dfs(nums, l + 1, mid - 1, target);
            }
        }
    }
}

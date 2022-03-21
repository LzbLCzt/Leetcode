package BinarySearch;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode153 {
    public static void main(String[] args) {
        
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}

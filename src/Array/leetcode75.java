package Array;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode75 {
    public static void main(String[] args) {
        
    }

    //循环不变量：定义三个区间（类似快排分区思想）,每个区间初始应该为空集
    // all in [0, p0] == 0
    // all in [p0, i] == 1
    // all in [p2, len - 1] == 2
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        int p0 = 0, i = 0, p2 = len - 1;
        while (i <= p2){
            if (nums[i] == 0){
                swap(nums, i ,p0);
                p0++;
                i++;
            }else if (nums[i] == 1){
                i++;
            }else {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

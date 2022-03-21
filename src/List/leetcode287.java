package List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode287 {
    public static void main(String[] args) {
        leetcode287 leetcode287 = new leetcode287();
        int ans = leetcode287.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(ans);
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0]; //*****
        int fast = nums[nums[0]];   //*****

        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int ans = 0;
        while (ans != slow){
            ans = nums[ans];
            slow = nums[slow];
        }

        return ans;
    }

}

package dp2;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode152 {
    public static void main(String[] args) {
        leetcode152 leetcode152 = new leetcode152();
        int ans = leetcode152.maxProduct(new int[]{-1, -2, -9, -6});
        System.out.println(ans);
    }


    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        int res = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i], Math.min(min[i-1] * nums[i], max[i-1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i-1] * nums[i], max[i-1] * nums[i]));
            res = Math.max(res, max[i]);
        }
        return res;
    }
}

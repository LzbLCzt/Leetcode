package doublePointer;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode713 {
    public static void main(String[] args) {
        leetcode713 leetcode713 = new leetcode713();
        int[] nums = new int[]{10,5,2,6};
        int ans = leetcode713.numSubarrayProductLessThanK(nums, 100);
        System.out.println(ans);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            //******始终能保证prod是子数组[left, right]的乘积
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

}

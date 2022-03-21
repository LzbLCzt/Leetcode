package doublePointer2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode713 {
    public static void main(String[] args) {
        leetcode713 leetcode713 = new leetcode713();
//        int[] nums = new int[]{10,5,2,6};
        int[] nums = new int[]{1,2,3};
        int ans = leetcode713.numSubarrayProductLessThanK(nums, 0);
        System.out.println(ans);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return 0;
        int res = 0, l = 0, product = 1;
        for (int r = 0; r < n; r++) {
            product *= nums[r];
            while (l <= r && product >= k){
                product /= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }

}

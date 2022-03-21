package Array;

public class leetcode209 {
    public static void main(String[] args) {
        leetcode209 leetcode209 = new leetcode209();
        int res = leetcode209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
//        int res = leetcode209.minSubArrayLen(5, new int[]{1,2,3,4,5});
        System.out.println(res);
//        int res = Arrays.binarySearch(new int[]{1, 1,1, 2,5, 5,7, 7,8}, 3);
//        System.out.println(res);
    }


    //方法一：暴力，O（n2）
//    public int minSubArrayLen(int target, int[] nums) {
//        int n = nums.length;
//        int len = n + 1;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            int curLen = n + 1;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum >= target && curLen > j - i + 1){
//                    curLen = j - i + 1;
//                    break;
//                }
//            }
//            len = Math.min(len, curLen);
//        }
//        return len == n + 1? 0: len;
//    }

    //方法二：前缀和 + 二分查找,O(n*logn), O(n)
//    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int ans = Integer.MAX_VALUE;
//        int[] sums = new int[n + 1];
//        // 为了方便计算，令 size = n + 1
//        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
//        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
//        // 以此类推
//        for (int i = 1; i <= n; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        for (int i = 1; i <= n; i++) {
//            int target = s + sums[i - 1];   //*****每次补一部分，再去查找，相当于在i-1到n的区间找s
//            int bound = Arrays.binarySearch(sums, target);
//            if (bound < 0) {
//                bound = -bound - 1; //
//            }
//            if (bound <= n) {
//                ans = Math.min(ans, bound - (i - 1));
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

    //方法三：滑动窗口，O(n),O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0, res = n + 1;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target){
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res == n + 1? 0: res;
    }
}

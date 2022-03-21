package BinarySearch2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode334 {
    public static void main(String[] args) {
        leetcode334 leetcode334 = new leetcode334();
//        boolean res = leetcode334.increasingTriplet(new int[]{1, 2, 3, 4, 5});
        boolean res = leetcode334.increasingTriplet(new int[]{2,1,5,0,4,6});
        System.out.println(res);
    }

    //思想：仍然将问题转化为： 最长递增子序列问题（Leetcode300）
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] tails = new int[n];
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j){
                int mid = (i + j) / 2;
                if (num > tails[mid])i = mid + 1;
                else j = mid;
            }
            tails[i] = num;
            if (j == res) res++;
            if (res > 2) return true;
        }
        return false;
    }

}

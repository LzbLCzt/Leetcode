package Other2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode4 {
    public static void main(String[] args) {
        leetcode4 leetcode4 = new leetcode4();
        double res = leetcode4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m) return findMedianSortedArrays(nums2, nums1);

        int totalLeft = (n + m + 1) / 2;
        int left = 0, right = n;
        while (left < right){
            int i = (left + right + 1) / 2;
            int j = totalLeft - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) right = i - 1;
            else left = i;
        }
        int i = left, j = totalLeft - i;
        int leftMax1 = i == 0? Integer.MIN_VALUE: nums1[i - 1];
        int leftMax2 = j == 0? Integer.MIN_VALUE: nums2[j - 1];
        int rightMin1 = i == n? Integer.MAX_VALUE: nums1[i];
        int rightMin2 = j == m? Integer.MAX_VALUE: nums2[j];
        if ((n + m) % 2 == 0){
            return (double)(Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2;
        }else {
            return Math.max(leftMax1, leftMax2);
        }
    }
}

package Other;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode4 {
    public static void main(String[] args) {
        leetcode4 leetcode4 = new leetcode4();
        double res = leetcode4.findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4});
        System.out.println(res);
        System.out.println();
    }

    //方法二：二分查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0, right = m;    //*****right = m，而不是right = m - 1
        while (left < right){
            int i = (left + right + 1) / 2; //*****
            int j = totalLeft - i;
            if (nums1[i-1] > nums2[j]){
                right = i - 1;//*****保证能够跳出while循环
            }else {
                left = i;
            }
        }

        int i = left;   //*****
        int j = totalLeft - i;
        int nums1LeftMax = i == 0? Integer.MIN_VALUE: nums1[i-1];
        int nums2LeftMax = j == 0? Integer.MIN_VALUE: nums2[j-1];
        int nums1RightMin = i == m? Integer.MAX_VALUE: nums1[i];
        int nums2RightMin = j == n? Integer.MAX_VALUE: nums2[j];

        if ((m + n) % 2 == 1){
            return Math.max(nums1LeftMax, nums2LeftMax);
        }else {
            return ((double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }

}

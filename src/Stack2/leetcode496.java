package Stack2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode496 {
    public static void main(String[] args) {
        leetcode496 leetcode496 = new leetcode496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = leetcode496.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    //时间：O（n+m）， 空间：O（m）
    int[] ans;
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>(); //k:nums2中的元素i，v：在nums2中比i大的第一个元素（题目要求的）
        ans = new int[n];
        Arrays.fill(ans,-1);

        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && nums2[stack.peekFirst()] < nums2[i]){
                int index = stack.pollFirst();
                map.put(nums2[index], nums2[i]);
            }
            stack.offerFirst(i);
        }

        for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}

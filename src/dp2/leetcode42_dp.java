package dp2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-04 13:43
 */
public class leetcode42_dp {
    public static void main(String[] args) {
        leetcode42_dp leetcode42_dp = new leetcode42_dp();
        int ans = leetcode42_dp.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(ans);
    }

    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekFirst()]){
                int mid = stack.pollFirst();
                if (stack.isEmpty()) break;
                int high = Math.min(height[i], height[stack.peekFirst()]) - height[mid];
                int width = i - stack.peekFirst() - 1;
                res += high * width;
            }
            stack.offerFirst(i);
        }
        return res;
    }
}

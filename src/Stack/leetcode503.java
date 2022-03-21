package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode503 {
    public static void main(String[] args) {
        
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i % n]){
                ans[stack.pollFirst()] = nums[i % n];
            }
            stack.offerFirst(i % n);
        }

        return ans;
    }
}

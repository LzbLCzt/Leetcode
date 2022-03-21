package doublePointer2;

import java.util.*;

public class leetcode239 {
    public static void main(String[] args) {
        leetcode239 leetcode239 = new leetcode239();
//        int[] res = leetcode239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] res = leetcode239.maxSlidingWindow(new int[]{7, 2, 4}, 2);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) return new int[]{Arrays.stream(nums).max().getAsInt()};
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}

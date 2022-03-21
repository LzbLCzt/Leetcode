package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new leetcode739().dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }

    /*
    方法：单调栈
    思路
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if(len < 1) return null;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]){
                ans[stack.peekFirst()] = i - stack.pollFirst();
            }

            stack.offerFirst(i);
        }

        return ans;
    }
}

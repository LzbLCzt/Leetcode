package Stack2;

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
    int[] ans;
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        ans = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]){
                int temp = stack.pollFirst();
                ans[temp] = i - temp;
            }
            stack.offerFirst(i);
        }
        return ans;
    }
}

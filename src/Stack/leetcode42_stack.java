package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode42_stack {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new leetcode42_stack().trap(height));
    }

    /*
    方法：单调栈
    核心思路：
        1. 维护一个栈，记录数组height的下标
        2. 每次尝试添加元素前，判断是否弹出元素
            2.1 若弹出元素，就计算当前元素能接多少水
        3. 添加元素
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekFirst()]){
                int index = stack.pollFirst();
                int width = 0,high = 0;
                //*****当栈为空时，证明当前index左侧已经没有墙了
                if (stack.isEmpty()){
                    break;
                }
                //******
                width = i - stack.peekFirst() - 1;
                high = Math.min(height[i], height[stack.peekFirst()]) - height[index];
                ans += width * high;

            }

            stack.offerFirst(i);
        }
        return ans;
    }
}

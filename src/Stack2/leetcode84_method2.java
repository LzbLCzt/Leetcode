package Stack2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode84_method2 {
    public static void main(String[] args) {
        
    }

    /*
    方法二：单调栈 + 哨兵机制进行优化

    时间 & 空间： O（N）
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return 0;
        if(len == 1) return heights[0];

        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i+1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(heights[0]);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekFirst()]){
                int height = heights[stack.pollFirst()];
                int width = i - stack.peekFirst() - 1;
                area = Math.max(area, width * height);
            }

            stack.offerFirst(i);
        }

        return area;
    }
}

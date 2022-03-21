package Stack;

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

        int area = 0;
        //创建一个新的数组，首尾分别是元素 = 0的哨兵
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i+1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);  //添加第一个哨兵，始终在栈底，不会被弹出来，因此保证了栈不为空

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekFirst()] > heights[i]){
                int height = heights[stack.removeFirst()];
                int width = i - stack.peekFirst() - 1;
                area = Math.max(area, width * height);
            }

            stack.addFirst(i);
        }

        return area;
    }
}

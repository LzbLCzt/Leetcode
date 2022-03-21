package Stack2;


import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode84 {
    public static void main(String[] args) {
//        int[] arr = {2,1,5,6,2,3};
        int[] arr = {1,1};
        leetcode84 leetcode84 = new leetcode84();
        int ans = leetcode84.largestRectangleArea(arr);
        System.out.println(ans);
    }

    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
        int[] tmp = Arrays.copyOfRange(heights, 0, n + 1);
        heights = tmp;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int j = stack.pop();
                int width = stack.isEmpty()? i: i - stack.peek() - 1;
                int high = heights[j];
                area = Math.max(area, width * high);
            }
            stack.push(i);
        }
        return area;
    }
}

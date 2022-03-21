package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode85 {
    public static void main(String[] args) {
        char[][] heights = {{'1','0','1','0','0'},{'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        int ans = new leetcode85().maximalRectangle(heights);
        System.out.println(ans);
    }

    /*
    方法一：单调栈
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int area = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    grid[i][j] = (i == 0? 0: grid[i-1][j]) + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        for (int i = 0; i < n; i++) {
            int[] heights = grid[i];
            area = Math.max(area, largestRectangleArea(heights));
        }

        return area;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        heights = Arrays.copyOf(heights, heights.length + 1);
        int ans = 0;
        //记录数组下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekFirst()]){
                int index = stack.pollFirst();
                int height = heights[index];
                //*********这里计算width必须是利用stack.peekFirst()才对，
                //参考例子{4, 2,0,3,2,5} => 原因：对于当前元素（从栈弹出的index），width取决于i和在栈中的栈顶元素（也就是index之前的元素，这个元素未必就是index - 1）
                int width;
                if (stack.isEmpty()){
                    width = i;
                }else {
                    width = i - stack.peekFirst() - 1;
                }

                ans = Math.max(ans, width * height);
            }
            stack.offerFirst(i);
        }

        return ans;
    }
}

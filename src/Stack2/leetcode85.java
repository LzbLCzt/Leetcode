package Stack2;

import java.util.Arrays;
import java.util.Stack;

public class leetcode85 {
    public static void main(String[] args) {
        int[] arr = new int[2];
        Arrays.fill(arr, 1);
        int[] res = Arrays.copyOfRange(arr, 0, 1);
        System.out.println(Arrays.toString(res));
    }

    int res;
    public int maximalRectangle(char[][] matrix) {
        res = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] cols = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    cols[i][j] = i == 0? 1: cols[i-1][j] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
//            int[] arr = new int[m];
            int[] arr = Arrays.copyOf(cols[i], m + 1);
            dfs(arr);
        }
        return res;
    }

    private void dfs(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int cur = stack.pop();
                int high = arr[cur];
                int width = stack.isEmpty()? i: i - stack.peek() - 1;
                res = Math.max(res, high * width);
            }
            stack.push(i);
        }
    }
}

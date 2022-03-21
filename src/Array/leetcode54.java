package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode54 {
    public static void main(String[] args) {
        leetcode54 leetcode54 = new leetcode54();
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> ans = leetcode54.spiralOrder(arr);
        System.out.println(ans);
    }
    List<Integer> ans;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m < 1 || n < 1) return new ArrayList<>();

        ans = new ArrayList<>();
        boolean[][] isVisited = new boolean[m][n];
        int flag = 1;   //表示方向，1,2,3,4分别表示向右、下、左、上

        searchElement(matrix, isVisited, flag, 0, 0);
        return ans;
    }

    private void searchElement(int[][] matrix, boolean[][] isVisited, int flag, int i, int j) {
        if(i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1 || isVisited[i][j]){
            if(flag == 1) {
                flag = 2;
                j--;
            }
            else if(flag == 2) {
                flag = 3;
                i--;
            }
            else if (flag == 3) {
                flag = 4;
                j++;
            }
            else if (flag == 4) {
                flag = 1;
                i++;
            }
        }else{
            ans.add(matrix[i][j]);
            isVisited[i][j] = true;
            if(ans.size() == matrix.length * matrix[0].length) return;
        }
        if(flag == 1) searchElement(matrix, isVisited, flag, i, j+1);
        else if(flag == 2) searchElement(matrix, isVisited,flag, i+1, j);
        else if(flag == 3) searchElement(matrix, isVisited,flag, i, j-1);
        else if(flag == 4) searchElement(matrix, isVisited,flag, i-1, j);
    }

    //方法二：按层模拟（官方代码）
    //时间、空间：O(nm), O(1)
    public List<Integer> spiralOrder2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(matrix == null || n < 1 || m < 1) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        //定义四个点
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left <= right){
            //1. 从左向右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            //2. 从上往下
            for (int j = top + 1; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            //3. 判断后（最后一层只有一个元素就不需要了）再从右往左，从下往上
            if(top < bottom && left < right){
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                for (int j = bottom - 1; j > top; j--) {
                    ans.add(matrix[j][top]);
                }
            }

            //每次循环后，缩小一圈
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}

package Other2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode48 {
    public static void main(String[] args) {
        leetcode48 leetcode48 = new leetcode48();
        leetcode48.rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //垂直线交换
        int l = 0, r = m - 1;
        while (l < r) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }
}

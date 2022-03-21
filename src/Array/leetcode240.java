package Array;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode240 {
    public static void main(String[] args) {
        
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }else if (target > matrix[i][j]){
                i++;
            }else if (target < matrix[i][j]){
                j--;
            }
        }
        return false;
    }
}
